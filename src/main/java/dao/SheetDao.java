package dao;

import models.Location;
import models.Sheet;
import utilities.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.SHEETS_TABLE_NAME;

public class SheetDao implements Dao<Sheet> {
    // TODO use `PreparedStatement`

    private DBCPDataSource dataSource;

    public SheetDao(DBCPDataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Sheet fetchSheetBySqlQuery(String sql) {
        Sheet sheet = null;
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                sheet = new Sheet(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getLong(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    private void insertByQuery(String sql) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Sheet> fetchSheetsBySqlQuery(String sql) {
        List<Sheet> sheets = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                sheets.add(new Sheet(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getLong(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sheets;
    }

    private void updateOrRemoveByQuery(String sql) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sheet get(long id) {
        return fetchSheetBySqlQuery("select * from " + SHEETS_TABLE_NAME + " where sheet_id=" + id);
    }

    @Override
    public List<Sheet> getAll() {
        return fetchSheetsBySqlQuery("select * from " + SHEETS_TABLE_NAME);
    }

    public boolean locationExists(Location location, long sheetId) {
        if (location == null) {
            throw new IllegalArgumentException("Please provide a Location object.");
        }
        Sheet sheet = this.get(sheetId);
        if (sheet == null) {
            throw new IllegalArgumentException("Please provide the id of an existing sheet.");
        }
        long rowsNumber = sheet.getRowsNumber();
        long columnsNumber = sheet.getColumnsNumber();
        return location.getRowIndex() <= rowsNumber && location.getColumnIndex() <= columnsNumber;
    }

    @Override
    public void save(Sheet sheet) {
        if (sheet == null) {
            throw new IllegalArgumentException("Please provide a Sheet object.");
        }
        String params = sheet.getId() + ", '" +
                sheet.getTitle() + "', " +
                sheet.getRowsNumber() + ", " +
                sheet.getColumnsNumber();
        insertByQuery("insert into " + SHEETS_TABLE_NAME + " values (" + params + ")");
    }

    @Override
    public void update(Sheet sheet, String[] params) {
        if (sheet == null) {
            throw new IllegalArgumentException("Please provide a Sheet object.");
        }
        // TODO add params checks (naming, values)
        // TODO add additional logic to checks (e.g. if `rows_number` and positive value, increment, and decrement with negative value)
        // TODO format string with placeholders (here and in other places)
        updateOrRemoveByQuery("update " + SHEETS_TABLE_NAME +
                " set " + params[0] + " = " + params[0] + " + " + params[1] +
                " where sheet_id = " + sheet.getId());
    }

    @Override
    public void delete(Sheet sheet) {
        if (sheet == null) {
            throw new IllegalArgumentException("Please provide a Sheet object.");
        }
        // On the app level, all its data is removed beforehand
        updateOrRemoveByQuery("delete from " + SHEETS_TABLE_NAME + " where sheet_id=" + sheet.getId());
    }
}

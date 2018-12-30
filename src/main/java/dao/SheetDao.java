package dao;

import models.Location;
import models.Sheet;
import org.apache.commons.lang3.ArrayUtils;
import utilities.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.*;

public class SheetDao implements Dao<Sheet> {
    // TODO get rid of magic strings (we have fields names configured)

    private DBCPDataSource dataSource;

    public SheetDao(DBCPDataSource dataSource) {
        if (dataSource == null) {
            throw new IllegalArgumentException("Data source must not be null.");
        }
        this.dataSource = dataSource;
    }

    public void updateOrRemoveByQuery(String sql) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sheet get(long id) {
        String sql = "select * from " + SHEETS_TABLE_NAME + " where sheet_id=?";
        Sheet sheet = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
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

    @Override
    public List<Sheet> getAll() {
        String sql = "select * from " + SHEETS_TABLE_NAME;
        List<Sheet> sheets = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
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
        String sql = "insert into " + SHEETS_TABLE_NAME + " values (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, sheet.getId());
            statement.setString(2, sheet.getTitle());
            statement.setLong(3, sheet.getRowsNumber());
            statement.setLong(4, sheet.getColumnsNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String prepareUpdateQuery(String[] params) {
        String sql = null;
        if (params[0].equals(ROWS_NUMBER_FIELD) || params[0].equals(COLUMNS_NUMBER_FIELD)) {
            String sign;
            if (params[1].contains("-")) {
                sign = "";
            } else {
                sign = " + ";
            }
            sql = "update " + SHEETS_TABLE_NAME +
                    " set " + params[0] + " = " + params[0] + sign + params[1];

        } else if (params[0].equals(TITLE_FIELD)) {
            sql = "update " + SHEETS_TABLE_NAME +
                    " set " + params[0] + " = '" + params[1] + "'";
        }
        return sql;
    }

    @Override
    public void update(Sheet sheet, String[] params) {
        // TODO update multiple values
        if (sheet == null) {
            throw new IllegalArgumentException("Please provide a Sheet object.");
        }
        if (!ArrayUtils.contains(SHEETS_ALLOWED_MODIFIABLE_FIELDS, params[0])) {
            throw new IllegalArgumentException("Please provide a valid sheets table field name as the first param.");
        }
        String sql = prepareUpdateQuery(params);
        if (sql == null) {
            throw new IllegalArgumentException("Please provide valid params for the update query to be prepared.");
        } else {
            sql += " where sheet_id = " + sheet.getId();
            updateOrRemoveByQuery(sql);
        }
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

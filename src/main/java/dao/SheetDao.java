package dao;

import models.Sheet;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.SHEETS_TABLE_NAME;

public class SheetDao implements Dao<Sheet> {

    public SheetDao() {
    }

    @Override
    public Sheet get(long id) {
        String sql = "select * from " + SHEETS_TABLE_NAME + " where sheet_id=" + id;
        Sheet sheet = null;
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
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

    public List<Sheet> getAll() {
        String sql = "select * from " + SHEETS_TABLE_NAME;
        List<Sheet> sheets = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
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

    @Override
    public void save(Sheet sheet) {
        String params = sheet.getId() + ", '" + sheet.getTitle() + "', " + sheet.getRowsNumber() + ", " + sheet.getColumnsNumber();
        String sql = "insert into " + SHEETS_TABLE_NAME + " values (" + params + ")";
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Sheet sheet, String[] params) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void delete(Sheet sheet) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }
}

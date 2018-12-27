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
        return null;
    }

    @Override
    public List<Sheet> getAll() {
        String sql = "select * from " + SHEETS_TABLE_NAME;
        List<Sheet> table = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                // TODO implement
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

    @Override
    public void save(Sheet spreadsheet) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void update(Sheet spreadsheet, String[] params) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void delete(Sheet spreadsheet) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }
}

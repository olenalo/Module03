package dao;

import models.Spreadsheet;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.sheetsTableName;

public class SheetDao implements Dao<Spreadsheet> {

    public SheetDao() {
    }

    // TODO SQL queries will go below

    @Override
    public Spreadsheet get(long id) {
        return null;
    }

    @Override
    public List<Spreadsheet> getAll() {
        String sql = "select * from " + sheetsTableName;
        List<Spreadsheet> table = new ArrayList<>();
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
    public void save(Spreadsheet spreadsheet) {

    }

    @Override
    public void update(Spreadsheet spreadsheet, String[] params) {

    }

    @Override
    public void delete(Spreadsheet spreadsheet) {

    }
}

package dao;

import models.DataCell;
import models.Location;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.DATA_CELLS_TABLE_NAME;

public class DataCellDao implements Dao<DataCell> {

    public DataCellDao() {
    }

    // TODO SQL queries will go below

    @Override
    public DataCell get(long id) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public DataCell get(Location location) {
        return null;
    }

    @Override
    public List<DataCell> getAll() {
        String sql = "select * from " + DATA_CELLS_TABLE_NAME;
        List<DataCell> table = new ArrayList<>();
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
    public void save(DataCell spreadsheet) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void update(DataCell spreadsheet, String[] params) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void delete(DataCell spreadsheet) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }
}

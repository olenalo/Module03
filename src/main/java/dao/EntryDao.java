package dao;

import models.Entry;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.ENTRIES_TABLE_NAME;

public class EntryDao implements Dao<Entry> {

    public EntryDao() {
    }

    @Override
    public Entry get(long id) {
        return null;
    }

    @Override
    public List<Entry> getAll() {
        String sql = "select * from " + ENTRIES_TABLE_NAME;
        List<Entry> table = new ArrayList<>();
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
    public void save(Entry spreadsheet) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void update(Entry spreadsheet, String[] params) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void delete(Entry spreadsheet) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }
}

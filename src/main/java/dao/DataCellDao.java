package dao;

import models.DataCell;
import models.Location;
import utilities.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.DATA_CELLS_TABLE_NAME;

public class DataCellDao implements Dao<DataCell> {

    public DataCellDao() {
    }

    @Override
    public DataCell get(long id) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    private List<DataCell> fetchCellsBySqlQuery(String sql) {
        List<DataCell> cells = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                cells.add(new DataCell(
                        rs.getLong(1),
                        new Location(rs.getLong(2), rs.getLong(3)),
                        rs.getString(4),
                        rs.getLong(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cells;
    }

    @Override
    public List<DataCell> getAll() {
        return this.fetchCellsBySqlQuery("select * from " + DATA_CELLS_TABLE_NAME);
    }

    public List<DataCell> getAllFilteredBy(long sheetId) {
        return this.fetchCellsBySqlQuery("select * from " + DATA_CELLS_TABLE_NAME + " where sheet_id=" + sheetId);
    }


    @Override
    public void save(DataCell cell) {
        String params = cell.getId() + ", " +
                cell.getLocation().getRowIndex() + ", " +
                cell.getLocation().getColumnIndex() + ", '" +
                cell.getValue() + "', " +
                cell.getSheetId();
        String sql = "insert into " + DATA_CELLS_TABLE_NAME + " values (" + params + ")";
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

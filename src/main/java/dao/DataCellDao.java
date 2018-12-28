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

    private DataCell fetchCellBySqlQuery(String sql) {
        DataCell cell = null;
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                cell = new DataCell(
                        new Location(rs.getLong(1), rs.getLong(2)),
                        rs.getString(3),
                        rs.getLong(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cell;
    }

    @Override
    public DataCell get(long id) {
        throw new UnsupportedOperationException("This method isn't supported (cell can be fetched only by location).");
    }

    public DataCell get(Location location, long sheetId) {
        String sql = "select * from " + DATA_CELLS_TABLE_NAME +
                " where row_index=" + location.getRowIndex() +
                " and column_index=" + location.getColumnIndex() +
                " and sheet_id=" + sheetId;
        return this.fetchCellBySqlQuery(sql);
    }

    private List<DataCell> fetchCellsBySqlQuery(String sql) {
        List<DataCell> cells = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                cells.add(new DataCell(
                        new Location(rs.getLong(1), rs.getLong(2)),
                        rs.getString(3),
                        rs.getLong(4)));
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

    private void insertByQuery(String sql) {
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Please provide a unique location for a sheet.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(DataCell cell) {
        // TODO check that location exists (with a query to `sheets`)
        String params = cell.getLocation().getRowIndex() + ", " +
                cell.getLocation().getColumnIndex() + ", '" +
                cell.getValue() + "', " +
                cell.getSheetId();
        String sql = "insert into " + DATA_CELLS_TABLE_NAME + " values (" + params + ")";
        this.insertByQuery(sql);
    }

    public void save(DataCell cell, long sheetId) {
        // this.insertByQuery(sql);
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

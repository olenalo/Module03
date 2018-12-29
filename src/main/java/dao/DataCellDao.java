package dao;

import models.DataCell;
import models.Location;
import utilities.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.DATA_CELLS_TABLE_NAME;

public class DataCellDao implements Dao<DataCell> {
    // TODO use `PreparedStatement`

    private DBCPDataSource dataSource;

    public DataCellDao(DBCPDataSource dataSource) {
        this.dataSource = dataSource;
    }

    private List<DataCell> fetchCellsBySqlQuery(String sql) {
        List<DataCell> cells = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
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

    private DataCell fetchCellBySqlQuery(String sql) {
        DataCell cell = null;
        try (Connection connection = dataSource.getConnection()) {
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

    private void insertByQuery(String sql) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            // TODO move, this only concerns `DataCell`
            System.out.println("Please provide a unique location for a sheet.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
    public DataCell get(long id) {
        throw new UnsupportedOperationException("This method isn't supported " +
                "(a cell can be fetched only by location).");
    }

    public DataCell get(Location location, long sheetId) {
        String sql = "select * from " + DATA_CELLS_TABLE_NAME +
                " where row_index=" + location.getRowIndex() +
                " and column_index=" + location.getColumnIndex() +
                " and sheet_id=" + sheetId;
        return fetchCellBySqlQuery(sql);
    }

    @Override
    public List<DataCell> getAll() {
        return fetchCellsBySqlQuery("select * from " + DATA_CELLS_TABLE_NAME);
    }

    public List<DataCell> getAllFilteredBy(long sheetId) {
        return fetchCellsBySqlQuery("select * from " + DATA_CELLS_TABLE_NAME + " where sheet_id=" + sheetId);
    }

    @Override
    public void save(DataCell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Please provide a DataCell object.");
        }
        String params = cell.getLocation().getRowIndex() + ", " +
                cell.getLocation().getColumnIndex() + ", '" +
                cell.getValue() + "', " +
                cell.getSheetId();
        String sql = "insert into " + DATA_CELLS_TABLE_NAME + " values (" + params + ")";
        insertByQuery(sql);
    }

    @Override
    public void update(DataCell cell, String[] params) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void delete(DataCell cell) {
        // TODO cover cases of removal by location (single datum / data slice)
        updateOrRemoveByQuery("delete from " + DATA_CELLS_TABLE_NAME + " where sheet_id=" + cell.getSheetId());
    }
}

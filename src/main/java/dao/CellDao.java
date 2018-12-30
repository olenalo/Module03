package dao;

import models.Cell;
import models.Location;
import utilities.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.DATA_CELLS_TABLE_NAME;

public class CellDao implements Dao<Cell> {
    // TODO use `PreparedStatement`

    private DBCPDataSource dataSource;

    public CellDao(DBCPDataSource dataSource) {
        if (dataSource == null) {
            throw new IllegalArgumentException("Data source must not be null.");
        }
        this.dataSource = dataSource;
    }

    private List<Cell> fetchCellsBySqlQuery(String sql) {
        List<Cell> cells = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                cells.add(new Cell(
                        new Location(rs.getLong(1), rs.getLong(2)),
                        rs.getString(3),
                        rs.getLong(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cells;
    }

    private Cell fetchCellBySqlQuery(String sql) {
        Cell cell = null;
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                cell = new Cell(
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
    public Cell get(long id) {
        throw new UnsupportedOperationException("This method isn't supported " +
                "(a cell can be fetched only by location).");
    }

    public Cell get(Location location, long sheetId) {
        if (location == null) {
            throw new IllegalArgumentException("Please provide a Location object.");
        }
        String sql = "select * from " + DATA_CELLS_TABLE_NAME +
                " where row_index=" + location.getRowIndex() +
                " and column_index=" + location.getColumnIndex() +
                " and sheet_id=" + sheetId;
        return fetchCellBySqlQuery(sql);
    }

    @Override
    public List<Cell> getAll() {
        return fetchCellsBySqlQuery("select * from " + DATA_CELLS_TABLE_NAME);
    }

    public List<Cell> getAllFilteredBy(long sheetId) {
        return fetchCellsBySqlQuery("select * from " + DATA_CELLS_TABLE_NAME + " where sheet_id=" + sheetId);
    }

    @Override
    public void save(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Please provide a Cell object.");
        }
        String params = cell.getLocation().getRowIndex() + ", " +
                cell.getLocation().getColumnIndex() + ", '" +
                cell.getValue() + "', " +
                cell.getSheetId();
        String sql = "insert into " + DATA_CELLS_TABLE_NAME + " values (" + params + ")";
        insertByQuery(sql);
    }

    @Override
    public void update(Cell cell, String[] params) {
        if (cell == null) {
            throw new IllegalArgumentException("Please provide a Cell object.");
        }
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void delete(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Please provide a Cell object.");
        }
        // TODO cover cases of removal by location (single datum / data slice)
        updateOrRemoveByQuery("delete from " + DATA_CELLS_TABLE_NAME + " where sheet_id=" + cell.getSheetId());
    }
}

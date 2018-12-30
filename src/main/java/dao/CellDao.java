package dao;

import models.Cell;
import models.Location;
import org.apache.commons.lang3.ArrayUtils;
import utilities.DBCPDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.*;

public class CellDao implements Dao<Cell> {
    // TODO get rid of magic strings (we have fields names configured)

    private DBCPDataSource dataSource;

    public CellDao(DBCPDataSource dataSource) {
        if (dataSource == null) {
            throw new IllegalArgumentException("Data source must not be null.");
        }
        this.dataSource = dataSource;
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
        String sql = "select * from " + CELLS_TABLE_NAME +
                " where row_index=?" +
                " and column_index=?" +
                " and sheet_id=?";
        Cell cell = null;
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, location.getRowIndex());
            statement.setLong(2, location.getColumnIndex());
            statement.setLong(3, sheetId);
            ResultSet rs = statement.executeQuery();
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

    @Override
    public List<Cell> getAll() {
        String sql = "select * from " + CELLS_TABLE_NAME;
        List<Cell> cells = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
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

    public List<Cell> getAllFilteredBy(long sheetId) {
        String sql = "select * from " + CELLS_TABLE_NAME + " where sheet_id=?";
        List<Cell> cells = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, sheetId);
            ResultSet rs = statement.executeQuery();
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

    @Override
    public void save(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Please provide a Cell object.");
        }
        String sql = "insert into " + CELLS_TABLE_NAME + " values (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cell.getLocation().getRowIndex());
            statement.setLong(2, cell.getLocation().getColumnIndex());
            statement.setString(3, cell.getValue());
            statement.setLong(4, cell.getSheetId());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Please provide a unique location for a sheet.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cell cell, String[] params) {
        // TODO update multiple values
        if (cell == null) {
            throw new IllegalArgumentException("Please provide a Cell object.");
        }
        if (!ArrayUtils.contains(CELLS_ALLOWED_MODIFIABLE_FIELDS, params[0])) {
            throw new IllegalArgumentException("Please provide a valid cells table field name as the first param.");
        }
        // Note: Incrementing and decrementing could be possible
        //  once values of different types can be provided
        String sql = "update " + CELLS_TABLE_NAME +
                " set " + params[0] + "=\"" + params[1] + "\"" +
                " where sheet_id = ?" +
                " and row_index = ?" +
                " and column_index = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cell.getSheetId());
            statement.setLong(2, cell.getLocation().getRowIndex());
            statement.setLong(3, cell.getLocation().getColumnIndex());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Please provide a unique cell location.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Please provide a Cell object.");
        }
        // TODO consider covering cases of removal by location (single datum / data slice)
        String sql = "delete from " + CELLS_TABLE_NAME + " where sheet_id=?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cell.getSheetId());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Please provide a unique cell location.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

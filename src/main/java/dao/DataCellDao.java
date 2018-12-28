package dao;

import models.DataCell;
import models.Location;
import models.Sheet;
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
                        rs.getLong(1),
                        new Location(rs.getLong(2), rs.getLong(3)),
                        rs.getString(4),
                        rs.getLong(5)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cell;
    }

    @Override
    public DataCell get(long id) {
        String sql = "select * from " + DATA_CELLS_TABLE_NAME + " where cell_id=" + id;
        return this.fetchCellBySqlQuery(sql);
    }

    public DataCell get(long cellId, long sheetId) {
        String sql = "select * from " + DATA_CELLS_TABLE_NAME +
                " where cell_id=" + cellId +
                " and sheet_id=" + sheetId;
        return this.fetchCellBySqlQuery(sql);
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
        // TODO check sheetId AND location for uniqueness (with another query?)
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

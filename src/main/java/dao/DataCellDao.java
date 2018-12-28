package dao;

import models.DataCell;
import models.Location;

import java.util.List;

import static configs.MySQLConfigs.DATA_CELLS_TABLE_NAME;
import static configs.MySQLConfigs.SHEETS_TABLE_NAME;
import static utilities.DaoUtilities.*;
import static utilities.DaoUtilities.updateOrRemoveByQuery;

public class DataCellDao implements Dao<DataCell> {

    public DataCellDao() {
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
        // TODO check that location exists (with a query to `sheets`)
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
        updateOrRemoveByQuery("delete from " + DATA_CELLS_TABLE_NAME + " where sheet_id=" + cell.getSheetId());
    }
}

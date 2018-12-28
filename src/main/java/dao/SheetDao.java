package dao;

import models.Location;
import models.Sheet;

import java.util.List;

import static configs.MySQLConfigs.SHEETS_TABLE_NAME;
import static utilities.DaoUtilities.fetchSheetBySqlQuery;
import static utilities.DaoUtilities.fetchSheetsBySqlQuery;
import static utilities.DaoUtilities.insertByQuery;
import static utilities.DaoUtilities.updateOrRemoveByQuery;

public class SheetDao implements Dao<Sheet> {

    public SheetDao() {
    }

    @Override
    public Sheet get(long id) {
        return fetchSheetBySqlQuery("select * from " + SHEETS_TABLE_NAME + " where sheet_id=" + id);
    }

    @Override
    public List<Sheet> getAll() {
        return fetchSheetsBySqlQuery("select * from " + SHEETS_TABLE_NAME);
    }

    public boolean locationExists(Location location, long sheetId) {
        Sheet sheet = this.get(sheetId);
        long rowsNumber = sheet.getRowsNumber();
        long columnsNumber = sheet.getColumnsNumber();
        return location.getRowIndex() <= rowsNumber && location.getColumnIndex() <= columnsNumber;
    }

    @Override
    public void save(Sheet sheet) {
        String params = sheet.getId() + ", '" +
                sheet.getTitle() + "', " +
                sheet.getRowsNumber() + ", " +
                sheet.getColumnsNumber();
        insertByQuery("insert into " + SHEETS_TABLE_NAME + " values (" + params + ")");
    }

    @Override
    public void update(Sheet sheet, String[] params) {
        // TODO add params checks (naming, values)
        // TODO add additional logic to checks (e.g. if `rows_number` and positive value, increment, and decrement with negative value)
        // TODO format string with placeholders (here and in other places)
        updateOrRemoveByQuery("update " + SHEETS_TABLE_NAME +
                " set " + params[0] + " = " + params[0] + " + " + params[1] +
                " where sheet_id = " + sheet.getId());
    }

    @Override
    public void delete(Sheet sheet) {
        // On the app level, all its data is removed beforehand
        updateOrRemoveByQuery("delete from " + SHEETS_TABLE_NAME + " where sheet_id=" + sheet.getId());
    }
}

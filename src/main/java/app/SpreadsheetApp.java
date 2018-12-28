package app;

import dao.DataCellDao;
import dao.SheetDao;
import models.DataCell;
import models.Location;
import models.Sheet;

import java.util.List;

import static configs.MySQLConfigs.ZERO_INDEX;

public class SpreadsheetApp {
    private static SheetDao sheetDao = new SheetDao();
    private static DataCellDao cellDao = new DataCellDao();

    public static void addSheet() {
        sheetDao.save(new Sheet(ZERO_INDEX));
    }

    public static void removeSheet() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static Sheet getSheet(long id) {
        return sheetDao.get(id);
    }

    public static List<Sheet> getAllSheets() {
        return sheetDao.getAll();
    }

    public static void addData(
            Location location,
            String value,
            Long sheetId) {
        cellDao.save(new DataCell(ZERO_INDEX, location, value, sheetId));
    }

    public static DataCell getDatum(long id) {
        return cellDao.get(id);
    }

    public static List<DataCell> getAllData() {
        return cellDao.getAll();
    }

    public static List<DataCell> getAllDataOfSheet(long sheetId) {
        return cellDao.getAllFilteredBy(sheetId);
    }

    // TODO get() datum of a particular sheet
    // TODO remove sheet (table)
    // TODO remove row/column
    // TODO remove data (single, slice etc)
    // TODO update - rename sheet (set custom sheet name)
    // TODO update datum/data/slice of data
    // TODO addData()  - other signatures (data, data slice)
    // TODO get() data/data slice of a particular sheet

}

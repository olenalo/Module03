package app;

import dao.DataCellDao;
import dao.SheetDao;
import models.DataCell;
import models.Location;
import models.Sheet;

import java.util.List;
import java.util.Map;

import static configs.MySQLConfigs.ZERO_INDEX;

public class SpreadsheetApp {
    private static SheetDao sheetDao = new SheetDao();
    private static DataCellDao cellDao = new DataCellDao();

    public static void addSheet() {
        sheetDao.save(new Sheet(ZERO_INDEX));
    }

    public static void removeSheet(long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void removeRow(long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void removeRow(long sheetId, long rowNumber) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void removeColumn(long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void removeColumn(long sheetId, long columnNumber) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static Sheet getSheet(long id) {
        return sheetDao.get(id);
    }

    public static List<Sheet> getAllSheets() {
        return sheetDao.getAll();
    }

    public static void addData(
            Location from,
            Location to,
            List<String> values,
            Long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void addData(Map<Location, String> data) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void addData(
            Location location,
            String value,
            Long sheetId) {
        cellDao.save(new DataCell(ZERO_INDEX, location, value, sheetId));
    }

    public static DataCell getData(long cellId) {
        return cellDao.get(cellId);
    }

    public static List<DataCell> getAllData() {
        return cellDao.getAll();
    }

    public static void removeData(Location location, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void removeData(Location from, Location to, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void removeData(Map<Location, String> data, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void renameSheet(long sheetId, String newName) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void updateData(Location location, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void updateData(Location from, Location to, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static void updateData(Map<Location, String> data, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static DataCell getDataOfSheet(long dataId, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static List<DataCell> getDataOfSheet(long sheetId) {
        return cellDao.getAllFilteredBy(sheetId);
    }

    public static List<DataCell> getDataOfSheet(Location location, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static List<DataCell> getDataOfSheet(Location from, Location to, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public static List<DataCell> getDataOfSheet(Map<Location, String> data, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

}

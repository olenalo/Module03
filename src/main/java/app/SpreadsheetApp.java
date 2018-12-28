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
    private SheetDao sheetDao = new SheetDao();
    private DataCellDao cellDao = new DataCellDao();

    public void addSheet() {
        sheetDao.save(new Sheet(ZERO_INDEX));
    }

    public void removeSheet(long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeRow(long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeRow(long sheetId, long rowNumber) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeColumn(long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeColumn(long sheetId, long columnNumber) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public Sheet getSheet(long id) {
        return sheetDao.get(id);
    }

    public List<Sheet> getAllSheets() {
        return sheetDao.getAll();
    }

    public void addData(
            Location from,
            Location to,
            List<String> values,
            Long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void addData(Map<Location, String> data) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void addData(
            Location location,
            String value,
            Long sheetId) {
        cellDao.save(new DataCell(ZERO_INDEX, location, value, sheetId));
    }

    public DataCell getData(long cellId) {
        return cellDao.get(cellId);
    }

    public List<DataCell> getAllData() {
        return cellDao.getAll();
    }

    public void removeData(Location location, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeData(Location from, Location to, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeData(Map<Location, String> data, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void renameSheet(long sheetId, String newName) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void updateData(Location location, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void updateData(Location from, Location to, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void updateData(Map<Location, String> data, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public DataCell getDataOfSheet(long dataId, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public List<DataCell> getDataOfSheet(long sheetId) {
        return cellDao.getAllFilteredBy(sheetId);
    }

    public List<DataCell> getDataOfSheet(Location location, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public List<DataCell> getDataOfSheet(Location from, Location to, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public List<DataCell> getDataOfSheet(Map<Location, String> data, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

}

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

    public SpreadsheetApp() {
        // TODO consider removing (sheet's created on s higher level, i.e. upon spreadsheet creation)
        this.addSheet(); // Default sheet is always created
    }

    public void addSheet() {
        sheetDao.save(new Sheet(ZERO_INDEX));
    }

    public void removeSheet(long sheetId) {
        // First, remove all sheet's data if any to meet constraint reqs
        cellDao.delete(new DataCell(sheetId));
        sheetDao.delete(new Sheet(sheetId));
    }

    public void addRow(long sheetId, long rowIndex) {
        // TODO permute
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void addRow(long sheetId) {
        sheetDao.update(new Sheet(sheetId), new String[]{"rows_number", "1"});
    }

    public void addRows(long sheetId, long rowsNumber) {
        sheetDao.update(new Sheet(sheetId), new String[]{"rows_number", String.valueOf(rowsNumber)});
    }

    public void addRows(long sheetId, long rowIndex, long rowsNumber) {
        // TODO permute
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void addColumn(long sheetId) {
        sheetDao.update(new Sheet(sheetId), new String[]{"columns_number", "1"});
    }

    public void addColumn(long sheetId, long columnId) {
        // TODO permute
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void addColumns(long sheetId, long columnsNumber) {
        sheetDao.update(new Sheet(sheetId), new String[]{"columns_number", String.valueOf(columnsNumber)});
    }

    public void removeRow(long sheetId) {
        sheetDao.update(new Sheet(sheetId), new String[]{"columns_number", "-1"});
    }

    public void removeRow(long sheetId, long rowNumber) {
        // TODO permute
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeRows(long sheetId, long rowsNumber) {
        sheetDao.update(new Sheet(sheetId), new String[]{"columns_number", String.valueOf(-rowsNumber)});
    }

    public void removeRows(long sheetId, int rowIndex, long rowNumber) {
        // TODO permute
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeColumn(long sheetId) {
        sheetDao.update(new Sheet(sheetId), new String[]{"columns_number", "-1"});
    }

    public void removeColumn(long sheetId, long columnNumber) {
        // TODO permute
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeColumns(long sheetId, long columnsNumber) {
        sheetDao.update(new Sheet(sheetId), new String[]{"columns_number", String.valueOf(columnsNumber)});
    }

    public void removeColumns(long sheetId, long columnIndex, long columnNumber) {
        // TODO permute
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

    public void addData(Map<Location, String> data, Long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void addData(
            Location location,
            String value,
            Long sheetId) {
        cellDao.save(new DataCell(location, value, sheetId));
    }

    public List<DataCell> getAllData() {
        return cellDao.getAll();
    }

    public void removeData(long sheetId) {
        cellDao.delete(new DataCell(sheetId));
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

    public List<DataCell> getAllDataCellsOfSheet(long sheetId) {
        return cellDao.getAllFilteredBy(sheetId);
    }

    public DataCell getCellOfSheet(Location location, long sheetId) {
        return cellDao.get(location, sheetId);
    }

    public List<DataCell> getDataCellsOfSheet(Location from, Location to, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public List<DataCell> getDataCellsOfSheet(Map<Location, String> data, long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

}

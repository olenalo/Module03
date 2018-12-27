package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static configs.SpreadsheetConfigs.DEFAULT_SPREADSHEET_NAME;

public class Spreadsheet {

    private List<Sheet> sheets = new ArrayList<>();
    private String spreadsheetTitle;
    // TODO consider adding "creation date" and "modif date" fields
    // TODO consider adding a "creator's / owner's username" field

    /**
     * Initialize a spreadsheet with a default sheet.
     */
    public Spreadsheet() {
        this.sheets.add(new Sheet());
        this.spreadsheetTitle = DEFAULT_SPREADSHEET_NAME;
    }

    public Spreadsheet(Long sheetId, Location from, Location to) {
        // TODO go on
    }

    public String getSpreadsheetTitle() {
        return spreadsheetTitle;
    }

    public void setSpreadsheetTitle(String spreadsheetTitle) {
        this.spreadsheetTitle = spreadsheetTitle;
    }

    /**
     * Add a new sheet.
     * <p>
     * Same as adding a new table.
     */
    public void addSheet() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    /**
     * Remove a particular sheet.
     * <p>
     * Same as removing a table.
     */
    public void removeSheet(Long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    // TODO implement the methods below; add methods with data
    public void addRow(Long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void addColumn(Long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeRow(Long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeColumn(Long sheetId) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    private Entry fetchSheetTable(Long sheetId) {
        // TODO consider using different data structure for `sheets` to avoid unnecessary instantiation
        int sheetIndex = this.sheets.indexOf(new Sheet(sheetId));
        if (sheetIndex == -1) {
            throw new NoSuchElementException("No sheet with id " + sheetId + " exists.");
        }
        Sheet sheet = this.sheets.get(sheetIndex);
        return sheet.getEntry();
    }

    public void addData(Long sheetId, Location location, String value) {
        Entry entry = this.fetchSheetTable(sheetId);
        entry.addData(location, value);
    }

    public void addData(Long sheetId, Location from, Location to, List<String> values) {
        Entry entry = this.fetchSheetTable(sheetId);
        entry.addData(from, to, values);
    }

    public void addData(Long sheetId, Map<Location, String> data) {
        Entry entry = this.fetchSheetTable(sheetId);
        entry.addData(data);
    }

    // TODO implement data removal
}

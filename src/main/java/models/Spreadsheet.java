package models;

import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {

    private List<Sheet> sheets = new ArrayList<>();
    private String spreadsheetTitle;

    // TODO add a field "creation date", "modif date" or so

    /**
     * Initialize a spreadsheet with a single sheet.
     *
     * @param sheetId
     * @param from
     * @param to
     */
    public Spreadsheet(Long sheetId, Location from, Location to) {
        this.sheets.add(new Sheet((long) 1));
        this.spreadsheetTitle = "Spreadsheet"; // default TODO move to a separate method
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
    public void removeSheet() {
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

}

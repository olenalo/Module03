package models;

import java.util.ArrayList;
import java.util.List;

import static configs.SpreadsheetConfigs.DEFAULT_SHEET_NAME;

public class Sheet {

    private Long sheetId;
    private String sheetTitle;
    private Long rowsNumber;
    private Long columnsNumber;
    private List<Entry> entries;

    /**
     * Initialize a sheet with a default entries.
     *
     * @param sheetId
     */
    public Sheet(Long sheetId) {
        this.sheetId = sheetId;
        this.entries = new ArrayList<>();
        this.sheetTitle = DEFAULT_SHEET_NAME;
    }

    /**
     * Initialize the very first sheet (single default).
     */
    public Sheet() {
        this.sheetId = (long) 1; // TODO move initial index to configs somewhere
        this.entries = new ArrayList<>();
        this.sheetTitle = DEFAULT_SHEET_NAME;
    }

    // TODO implement the methods below; add methods with data
    public void addRow() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void addColumn() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeRow() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeColumn() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
        // TODO check for uniqueness
        this.sheetId = sheetId;
    }

    public String getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(String sheetTitle) {
        this.sheetTitle = sheetTitle;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void addData() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }


    /**
     * Get a slice of the sheet data.
     *
     * @param from
     * @param to
     */
    public void getData(Location from, Location to) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public Long getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(Long rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public Long getColumnsNumber() {
        return columnsNumber;
    }

    public void setColumnsNumber(Long columnsNumber) {
        this.columnsNumber = columnsNumber;
    }
}

package models;

import java.util.*;

import static configs.SpreadsheetConfigs.DEFAULT_SHEET_NAME;
import static configs.SpreadsheetConfigs.DEFAULT_ROWS_NUMBER;
import static configs.SpreadsheetConfigs.DEFAULT_COLUMNS_NUMBER;

public class Sheet {

    private String sheetTitle;
    private Long rowsNumber;
    private Long columnsNumber;
    private Map<Location, String> entries;

    /**
     * Initialize a sheet with a default entries.
     */
    public Sheet() {
        this.entries = new HashMap<>();
        this.initializeDefaultSize();
        this.sheetTitle = DEFAULT_SHEET_NAME;
    }

    public void initializeDefaultSize() {
        this.rowsNumber = DEFAULT_ROWS_NUMBER;
        this.columnsNumber = DEFAULT_COLUMNS_NUMBER;
    }

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

    public String getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(String sheetTitle) {
        this.sheetTitle = sheetTitle;
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

    public Map<Location, String> getEntries() {
        return entries;
    }

    /**
     * Get a slice of the sheet data.
     *
     * @param from
     * @param to
     */
    public void getEntries(Location from, Location to) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    // TODO make it possible to add values of different types

    /**
     * Add a single value to a cell (datum).
     *
     * @param location
     * @param value
     */
    public void addData(Location location, String value) {
        entries.put(location, value);
    }

    /**
     * Add data to multiple cells.
     *
     * @param from
     * @param to
     * @param values
     */
    public void addData(Location from, Location to, List<String> values) {
        // TODO check location (no data can be added to non-existing cell)
        // TODO fill in the data; non-existent values to become `null`?
    }

    /**
     * Add data to multiple cells.
     *
     * @param data
     */
    public void addData(Map<Location, String> data) {
        // TODO check location (no data can be added to non-existing cell)
        // TODO fill in the data
    }


    // TODO implement data removal
}

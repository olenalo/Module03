package models;

import java.util.Objects;

import static configs.SpreadsheetConfigs.DEFAULT_SHEET_NAME;

public class Sheet {

    private Long sheetId;
    private String sheetTitle;
    private Table table;

    /**
     * Initialize a sheet with a default table.
     *
     * @param sheetId
     */
    public Sheet(Long sheetId) {
        this.sheetId = sheetId;
        this.table = new Table();
        this.sheetTitle = DEFAULT_SHEET_NAME;
    }

    /**
     * Initialize the very first sheet (single default).
     */
    public Sheet() {
        this.sheetId = (long) 1; // TODO move initial index to configs somewhere
        this.table = new Table();
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

    public Table getTable() {
        return table;
    }

    public void addData() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void getData(Location from, Location to) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sheet sheet = (Sheet) o;
        return sheetId.equals(sheet.sheetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheetId);
    }
}

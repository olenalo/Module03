package models;

import java.util.Objects;

import static configs.SpreadsheetConfigs.DEFAULT_SHEET_NAME;
import static configs.SpreadsheetConfigs.DEFAULT_ROWS_NUMBER;
import static configs.SpreadsheetConfigs.DEFAULT_COLUMNS_NUMBER;

public class Sheet {

    private Long id;
    private String title;
    // Available rows and columns numbers (not necessarily filled in)
    private Long rowsNumber;
    private Long columnsNumber;

    /**
     * Initialize a sheet with a default entries.
     */
    public Sheet(long id) {
        this.id = id;
        this.initializeDefaultSize();
        this.title = DEFAULT_SHEET_NAME; // TODO make it unique for each sheet
    }

    public Sheet(long id, String title, long rowsNumber, long columnsNumber) {
        this.id = id;
        this.title = title;
        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnsNumber;
    }

    private void initializeDefaultSize() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getRowsNumber() {
        return rowsNumber;
    }

    public void setRowsNumber(long rowsNumber) {
        this.rowsNumber = rowsNumber;
    }

    public long getColumnsNumber() {
        return columnsNumber;
    }

    public void setColumnsNumber(long columnsNumber) {
        this.columnsNumber = columnsNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", rowsNumber=" + rowsNumber +
                ", columnsNumber=" + columnsNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sheet)) return false;
        Sheet sheet = (Sheet) o;
        return id.equals(sheet.id) &&
                title.equals(sheet.title) &&
                rowsNumber.equals(sheet.rowsNumber) &&
                columnsNumber.equals(sheet.columnsNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, rowsNumber, columnsNumber);
    }
}

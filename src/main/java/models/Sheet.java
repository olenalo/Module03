package models;

import static configs.SpreadsheetConfigs.DEFAULT_SHEET_NAME;
import static configs.SpreadsheetConfigs.DEFAULT_ROWS_NUMBER;
import static configs.SpreadsheetConfigs.DEFAULT_COLUMNS_NUMBER;

public class Sheet {

    private Long id;
    private String title;
    private Long rowsNumber;
    private Long columnsNumber;

    /**
     * Initialize a sheet with a default entries.
     */
    public Sheet(Long id) {
        this.id = id;
        this.initializeDefaultSize();
        this.title = DEFAULT_SHEET_NAME; // TODO make it unique for each sheet
    }

    public Sheet(Long id, String title, Long rowsNumber, Long columnsNumber) {
        this.id = id;
        this.title = title;
        this.rowsNumber = rowsNumber;
        this.columnsNumber = columnsNumber;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


}

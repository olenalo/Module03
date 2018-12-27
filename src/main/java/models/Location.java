package models;

public class Location {

    private Long rowIndex;
    private Long columnIndex;

    public Location(Long rowIndex, Long columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public Long getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Long rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Long getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(Long columnIndex) {
        this.columnIndex = columnIndex;
    }
}

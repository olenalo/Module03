package models;

public class Location {

    private long rowIndex;
    private long columnIndex;

    public Location(long rowIndex, long columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public long getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Long rowIndex) {
        this.rowIndex = rowIndex;
    }

    public long getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(long columnIndex) {
        this.columnIndex = columnIndex;
    }

    @Override
    public String toString() {
        return "Location{" +
                "rowIndex=" + rowIndex +
                ", columnIndex=" + columnIndex +
                '}';
    }
}

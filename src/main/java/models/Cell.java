package models;

import java.util.Objects;

public class Cell {

    private Long sheetId;
    private Location location;
    private String value;  // TODO allow for creating values of different types

    public Cell(long sheetId) {
        this.sheetId = sheetId;
    }

    public Cell(Location location, String value, long sheetId) {
        this.location = location;
        this.value = value;
        this.sheetId = sheetId;
    }

    public long getSheetId() {
        return sheetId;
    }

    public void setSheetId(long sheetId) {
        this.sheetId = sheetId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;
        Cell cell = (Cell) o;
        return sheetId.equals(cell.sheetId) &&
                location.equals(cell.location) &&
                value.equals(cell.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheetId, location, value);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "sheetId=" + sheetId +
                ", location=" + location +
                ", value='" + value + '\'' +
                '}';
    }
}

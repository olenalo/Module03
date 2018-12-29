package models;

import java.util.Objects;

public class Cell {

    private Long sheetId;
    private Location location;
    private String value;  // TODO allow for creating values of different types

    public Cell(Long sheetId) {
        this.sheetId = sheetId;
    }

    public Cell(Location location, String value, Long sheetId) {
        this.location = location;
        this.value = value;
        this.sheetId = sheetId;
    }

    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
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
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return sheetId.equals(cell.sheetId) &&
                location.equals(cell.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheetId, location);
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

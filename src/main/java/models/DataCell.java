package models;

import java.util.Objects;

public class DataCell {

    private Long id;
    private Long sheetId;
    private Location location;
    private String value;

    public DataCell(Long id, Location location, String value, Long sheetId) {
        this.id = id;
        this.location = location;
        this.value = value;
        this.sheetId = sheetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        DataCell dataCell = (DataCell) o;
        return sheetId.equals(dataCell.sheetId) &&
                location.equals(dataCell.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sheetId, location);
    }

    @Override
    public String toString() {
        return "DataCell{" +
                "id=" + id +
                ", sheetId=" + sheetId +
                ", location=" + location +
                ", value='" + value + '\'' +
                '}';
    }
}

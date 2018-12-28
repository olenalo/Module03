package models;

import java.util.Map;
import java.util.Objects;

import static configs.MySQLConfigs.FIRST_DB_ENTRY_ID;

public class DataCell {

    private Long id;
    private Map<Location, String> data;

    public DataCell(Map<Location, String> data) {
        this.id = FIRST_DB_ENTRY_ID;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Location, String> getData() {
        return data;
    }

    public void setData(Map<Location, String> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataCell dataCell = (DataCell) o;
        return data.equals(dataCell.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

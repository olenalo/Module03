package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    private Long tableId;
    private Map<Location, String> data;

    public Table() {
        this.data = new HashMap<>();
        this.initializeDefaultTable();
    }

    public void initializeDefaultTable() {
        // TODO refactor with loops, using `SpreadsheetConfigs`
        // TODO consider removing; this is GUI actually
        data.put(new Location((long) 0, (long) 0), "");
        data.put(new Location((long) 0, (long) 1), "");
        data.put(new Location((long) 1, (long) 0), "");
        data.put(new Location((long) 1, (long) 1), "");
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Map<Location, String> getData() {
        return data;
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

    // TODO make it possible to add values of different types

    /**
     * Add a single value to a cell (datum).
     *
     * @param location
     * @param value
     */
    public void addData(Location location, String value) {
        // TODO check location (no data can be added to non-existing cell)
        data.put(location, value);
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
}

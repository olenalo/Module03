package models;

import java.util.HashMap;
import java.util.Map;

public class Table {

    private Long tableId;
    private Map<Location, String> table;

    /**
     * Initialize a default table.
     * <p>
     * Default table has 2 x 2 size filled with empty values.
     */
    public Table() {
        this.table = new HashMap<>();
        this.initializeDefaultTable();
    }

    public void initializeDefaultTable() {
        // TODO refactor with loops
        table.put(new Location((long) 0, (long) 0), "");
        table.put(new Location((long) 0, (long) 1), "");
        table.put(new Location((long) 1, (long) 0), "");
        table.put(new Location((long) 1, (long) 1), "");
    }

    public void addData() {
        // TODO implement
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


    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Map<Location, String> getTable() {
        return table;
    }
}

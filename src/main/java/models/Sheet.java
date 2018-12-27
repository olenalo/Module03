package models;

import java.util.HashMap;
import java.util.Map;

public class Sheet {

    private Long sheetId;
    private String sheetTitle;
    private Map<Location, String> table; // One table per sheets, with lots of null values

    /**
     * Initialize a sheet with a default table.
     * <p>
     * Default table has 2 x 2 size filled with empty values.
     *
     * @param sheetId
     */
    public Sheet(Long sheetId) {
        this.sheetId = sheetId;
        this.sheetTitle = String.valueOf(sheetId);
        this.table = new HashMap<>();
        // TODO refactor with loops
        table.put(new Location((long) 0, (long) 0), "");
        table.put(new Location((long) 0, (long) 1), "");
        table.put(new Location((long) 1, (long) 0), "");
        table.put(new Location((long) 1, (long) 1), "");
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

    // TODO consider placing in add/remove methods
    public void storeData() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void getData(Location from, Location to) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public Long getSheetId() {
        return sheetId;
    }

    public void setSheetId(Long sheetId) {
        this.sheetId = sheetId;
    }

    public String getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(String sheetTitle) {
        this.sheetTitle = sheetTitle;
    }

    public Map<Location, String> getTable() {
        return table;
    }
}

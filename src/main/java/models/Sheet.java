package models;

public class Sheet {

    private Long sheetId;
    private String sheetTitle;
    private Table table;

    /**
     * Initialize a sheet with a default table.
     *
     * @param sheetId
     */
    public Sheet(Long sheetId) {
        this.sheetId = sheetId;
        this.sheetTitle = String.valueOf(sheetId);
        this.table = new Table();
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

    public Table getTable() {
        return table;
    }


    // TODO consider placing in add/remove methods
    public void storeData() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void getData(Location from, Location to) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }
}

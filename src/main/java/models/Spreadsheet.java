package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spreadsheet {

    private Map<Integer, Entry> table;

    public Spreadsheet() {
        this.table = new HashMap<>();
    }

    public Spreadsheet(Entry from, Entry to) {
        this.table = new HashMap<>();
    }

    // TODO implement the methods below
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

    public void addTable(List<Entry> locations) {
        // TODO check locations
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void removeTable(List<Entry> locations) {
        // TODO check locations
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    // TODO consider placing in add/remove methods
    public void storeData() {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    public void getData(List<Entry> locations) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }


}

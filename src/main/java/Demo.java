import app.SpreadsheetApp;
import models.Location;

import static utilities.PrintUtils.printCells;
import static utilities.PrintUtils.printSheets;

public class Demo {

    public static void main(String[] args) {
        // Sheets
        // Add a new sheet
        SpreadsheetApp.addSheet(); // TODO consider moving one call to `SpreadsheetApp` (should happen at least once)
        SpreadsheetApp.addSheet();
        // Print all sheets
        printSheets(SpreadsheetApp.getAllSheets());

        // Entries
        // Add a single value to a cell
        SpreadsheetApp.addData(
                new Location((long) 0, (long) 0),
                "123",
                (long) 1);
        // Print all data
        printCells(SpreadsheetApp.getAllData());

        // FIXME/Implement: Print all data of a sheet
        // SpreadsheetApp.getAllDataOfSheet((long) 1);

    }

}

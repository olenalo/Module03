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
        System.out.println("----------------------------");
        printSheets(SpreadsheetApp.getAllSheets());

        // Entries
        // Add a single value to a cell
        SpreadsheetApp.addData(
                new Location((long) 0, (long) 0),
                "123",
                (long) 1);
        SpreadsheetApp.addData(
                new Location((long) 0, (long) 1),
                "Some Value",
                (long) 1);
        // TODO check failure if adding with non-existing location
        SpreadsheetApp.addData(
                new Location((long) 0, (long) 0),
                "123-568",
                (long) 2);
        // Print all data
        System.out.println("----------------------------");
        printCells(SpreadsheetApp.getAllData());

        // Print all data of a sheet
        System.out.println("----------------------------");
        printCells(SpreadsheetApp.getAllDataOfSheet((long) 1));

    }

}

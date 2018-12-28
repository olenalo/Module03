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

        System.out.println("----------- Print the 1st sheet -----------");
        System.out.println(SpreadsheetApp.getSheet((long) 1));

        System.out.println("----------- Print all sheets -----------");
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

        System.out.println("----------- Print the first datum -----------");
        System.out.println(SpreadsheetApp.getDatum((long) 1));

        System.out.println("----------- Print all data -----------");
        printCells(SpreadsheetApp.getAllData());

        System.out.println("----------- Print all data of the 1st sheet sheet -----------");
        printCells(SpreadsheetApp.getAllDataOfSheet((long) 1));

    }

}

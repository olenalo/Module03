import app.SpreadsheetApp;
import models.Location;

import static utilities.PrintUtils.printCells;
import static utilities.PrintUtils.printSheets;

public class Demo {

    public static void main(String[] args) {
        SpreadsheetApp app = new SpreadsheetApp();
        // Sheets
        // Add a new sheet
        app.addSheet(); // TODO consider moving one call to `SpreadsheetApp` (should happen at least once)
        app.addSheet();

        System.out.println("----------- Print the 1st sheet -----------");
        System.out.println(app.getSheet((long) 1));

        System.out.println("----------- Print all sheets -----------");
        printSheets(app.getAllSheets());

        // Entries
        // Add a single value to a cell
        app.addData(
                new Location((long) 0, (long) 0),
                "123",
                (long) 1);
        app.addData(
                new Location((long) 0, (long) 1),
                "Some Value",
                (long) 1);
        // TODO check failure if adding with non-existing location
        app.addData(
                new Location((long) 0, (long) 0),
                "123-568",
                (long) 2
        );

        System.out.println("----------- Print the first datum -----------");
        System.out.println(app.getData((long) 1));

        System.out.println("----------- Print all data -----------");
        printCells(app.getAllData());

        System.out.println("----------- Print all data of the 1st sheet sheet -----------");
        printCells(app.getDataOfSheet((long) 1));

        // System.out.println("----------- Print the first datum of the first sheet-----------");
        // System.out.println(app.getDataOfSheet((long) 1, (long) 1));
        // ...

    }

}

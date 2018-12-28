import app.SpreadsheetApp;
import models.Location;

import static utilities.PrintUtils.printCells;
import static utilities.PrintUtils.printSheets;

public class Demo {

    public static void main(String[] args) {
        SpreadsheetApp app = new SpreadsheetApp();

        // Sheets
        // Add a new sheet (table)
        // Two of them will exist as one was added upon the app launch
        app.addSheet();
        app.addSheet();
        app.removeSheet(3);

        app.addRow(1);
        app.addRow(1);
        // app.removeRow(1); // FIXME
        // app.removeRows(1, 2); // FIXME
        app.addColumn(1);
        app.addColumn(1);
        // app.removeColumn(1); // FIXME

        app.addRows(2, 10);
        app.addColumns(2, 10);
        // app.removeColumns(2, 2); // FIXME

        System.out.println("----------- Print the 1st sheet -----------");
        System.out.println(app.getSheet((long) 1));
        System.out.println("----------- Print the 2nd sheet -----------");
        System.out.println(app.getSheet((long) 2));

        System.out.println("----------- Print all sheets -----------");
        printSheets(app.getAllSheets());

        // Entries
        // Add a single value to a cell
        app.addData(
                new Location((long) 0, (long) 0),
                "123",
                (long) 1
        );
        app.addData(
                new Location((long) 0, (long) 1),
                "Some Value",
                (long) 1
        );
        // TODO check failure if adding with non-existing location
        // TODO check failure if adding with non-unique location
        app.addData(
                new Location((long) 0, (long) 0),
                "123-568",
                (long) 2
        );
        app.addData(
                new Location((long) 1, (long) 1),
                "123-56879 La la la",
                (long) 2
        );

        System.out.println("----------- Print all data -----------");
        printCells(app.getAllData());

        System.out.println("----------- Print all data of the 1st sheet sheet -----------");
        printCells(app.getAllDataCellsOfSheet((long) 1));

        System.out.println("----------- Print the datum of the first sheet by location-----------");
        System.out.println(app.getCellOfSheet(new Location((long) 0, (long) 0), (long) 1));

        app.removeSheet(2); // ensure all data is removed from `cells` (it is, otherwise getting constraint violation exception)
        System.out.println("----------- Print all sheets again (after removal) -----------");
        printSheets(app.getAllSheets());

    }

}

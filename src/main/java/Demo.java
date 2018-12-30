import app.SpreadsheetApp;
import models.Cell;
import models.Location;

import static configs.MySQLConfigs.CELL_VALUE_FIELD;
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
        app.removeRow(1);
        app.removeRows(1, 2);
        app.addColumn(1);
        app.addColumn(1);
        app.removeColumn(1);
        app.renameSheet(1, "MyFirstSheet");

        app.addRows(2, 10);
        app.addColumns(2, 10);
        app.removeColumns(2, 2);

        System.out.println("----------- Print the 1st sheet -----------");
        System.out.println(app.getSheet(1));
        System.out.println("----------- Print the 2nd sheet -----------");
        System.out.println(app.getSheet(2));

        System.out.println("----------- Print all sheets -----------");
        printSheets(app.getAllSheets());

        // Entries
        // Add a single value to a cell
        app.addData(
                new Location(0, 0),
                "123",
                1
        );
        app.addData(
                new Location(0, 1),
                "Some Value",
                1
        );
        app.addData(
                new Location(0, 0),
                "123-568",
                2
        );
        app.addData(
                new Location(1, 1),
                "123-56879 La la la",
                2
        );
        // Check failure if adding with non-existing location
        /*
        app.addData(
                new Location(23, 1123),
                "123-56879 La la la la la la",
                2
        );
        */

        // Check failure if adding with non-unique location
        /*
        app.addData(
                new Location(1, 1),
                "123-56879 La la la",
                2
        );
        */


        System.out.println("----------- Print all data -----------");
        printCells(app.getAllData());

        app.updateData(new Cell(new Location(1, 1), 2),
                new String[]{CELL_VALUE_FIELD, "New Value"});
        System.out.println("----------- Print all data again (after the change) -----------");
        printCells(app.getAllData());

        // Check failure if updating at non-existing location
        /*
        app.updateData(new Cell(new Location(23, 123), 2),
                new String[]{CELL_VALUE_FIELD, "New Value"});
        */

        // Check failure if updating at non-existing sheet
        /*
        app.updateData(new Cell(new Location(1, 1), 2222),
                new String[]{CELL_VALUE_FIELD, "New Value"});
        */

        System.out.println("----------- Print all data of the 1st sheet sheet -----------");
        printCells(app.getAllDataCellsOfSheet(1));

        System.out.println("----------- Print the datum of the first sheet by location-----------");
        System.out.println(app.getCellOfSheet(new Location(0, 0), 1));

        app.removeSheet(2); // ensure all data is removed from `cells` (it is, otherwise getting constraint violation exception)
        System.out.println("----------- Print all sheets again (after removal) -----------");
        printSheets(app.getAllSheets());

        app.removeData(1);
        System.out.println("----------- Print all data again (after removal) -----------");
        printCells(app.getAllData());  // Ensure it's empty

        System.out.println("----------- -----------");
    }

}

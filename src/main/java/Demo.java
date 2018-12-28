import app.SpreadsheetApp;

import static utilities.PrintUtils.printAllSheets;

public class Demo {

    public static void main(String[] args) {
        SpreadsheetApp.addSheet();
        printAllSheets(SpreadsheetApp.getAllSheets());
    }

}

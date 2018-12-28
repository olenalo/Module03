package app;

import dao.SheetDao;
import models.Location;
import models.Sheet;

import java.util.List;
import java.util.Map;

public class SpreadsheetApp {
    private static SheetDao sheetDao = new SheetDao();
    private static long sheetsCounter = 0;

    public static void addSheet() {
        sheetDao.save(new Sheet(sheetsCounter));
        sheetsCounter++;
    }


    public static void removeSheet() {

    }

    public static void addData(Long sheetId, Map<Location, String> data) {

    }

    public static List<Sheet> getAllSheets() {
        return sheetDao.getAll();
    }

    // TODO other CRUD methods go below
    // TODO renaming API (set spreadsheet and sheet name)
    // TODO create new sheet

}

package app;

import dao.SheetDao;
import models.Sheet;

import java.util.List;

public class SpreadsheetApp {
    private static SheetDao sheetDao = new SheetDao();

    public static List<Sheet> getAllData() {
        return sheetDao.getAll();
    }

    // TODO other CRUD methods go below
    // TODO renaming API (set spreadsheet and sheet name)
}

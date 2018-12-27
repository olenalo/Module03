package app;

import dao.SheetDao;
import models.Spreadsheet;

import java.util.List;

public class SpreadsheetApp {
    private SheetDao spreadsheetDao = new SheetDao();

    public List<Spreadsheet> getAllData() {
        return spreadsheetDao.getAll();
    }

    // TODO other CRUD methods go below
    // TODO renaming API (set spreadsheet and sheet name)
}

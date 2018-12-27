package app;

import dao.SpreadsheetDao;
import models.Spreadsheet;

import java.util.List;

public class SpreadsheetApp {
    private SpreadsheetDao spreadsheetDao = new SpreadsheetDao();

    public List<Spreadsheet> getAllData() {
        return spreadsheetDao.getAll();
    }

    // TODO other CRUD methods go below
}

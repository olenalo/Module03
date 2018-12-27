package dao;

import models.Spreadsheet;

import java.util.List;

import static configs.MySQLConfigs.SPREADSHEET_TABLE_NAME;

public class SpreadsheetDao implements Dao<Spreadsheet> {

    public SpreadsheetDao() {
    }

    // TODO combine sheet and table dao here

    @Override
    public Spreadsheet get(long id) {
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public List<Spreadsheet> getAll() {
        String sql = "select * from " + SPREADSHEET_TABLE_NAME;
        throw new UnsupportedOperationException("This method isn't implemented yet");
    }

    @Override
    public void save(Spreadsheet spreadsheet) {

    }

    @Override
    public void update(Spreadsheet spreadsheet, String[] params) {

    }

    @Override
    public void delete(Spreadsheet spreadsheet) {

    }
}

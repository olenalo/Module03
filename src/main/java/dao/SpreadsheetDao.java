package dao;

import models.Spreadsheet;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static configs.MySQLConfigs.spreadsheetTable;

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
        String sql = "select * from " + spreadsheetTable;
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

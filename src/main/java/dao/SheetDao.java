package dao;

import models.Location;
import models.Sheet;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static configs.MySQLConfigs.SHEETS_TABLE_NAME;
import static utilities.DaoUtilities.*;

public class SheetDao implements Dao<Sheet> {

    public SheetDao() {
    }

    @Override
    public Sheet get(long id) {
        String sql = "select * from " + SHEETS_TABLE_NAME + " where sheet_id=" + id;
        Sheet sheet = null;
        // TODO consider moving the logic below to `DaoUtilities`
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                sheet = new Sheet(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getLong(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sheet;
    }

    @Override
    public List<Sheet> getAll() {
        return fetchSheetsBySqlQuery("select * from " + SHEETS_TABLE_NAME);
    }

    public boolean locationExists(Location location, long sheetId) {
        Sheet sheet = this.get(sheetId);
        long rowsNumber = sheet.getRowsNumber();
        long columnsNumber = sheet.getColumnsNumber();
        return location.getRowIndex() <= rowsNumber && location.getColumnIndex() <= columnsNumber;
    }

    @Override
    public void save(Sheet sheet) {
        String params = sheet.getId() + ", '" +
                sheet.getTitle() + "', " +
                sheet.getRowsNumber() + ", " +
                sheet.getColumnsNumber();
        insertByQuery("insert into " + SHEETS_TABLE_NAME + " values (" + params + ")");
    }

    @Override
    public void update(Sheet sheet, String[] params) {
        // TODO add params checks (naming, values)
        // TODO add additional logic to checks (e.g. if `rows_number` and positive value, increment, and decrement with negative value)
        // TODO format string with placeholders (here and in other places)
        updateOrRemoveByQuery("update " + SHEETS_TABLE_NAME +
                " set " + params[0] + " = " + params[0] + " + " + params[1] +
                " where sheet_id = " + sheet.getId());
    }

    @Override
    public void delete(Sheet sheet) {
        // On the app level, all its data is removed beforehand
        updateOrRemoveByQuery("delete from " + SHEETS_TABLE_NAME + " where sheet_id=" + sheet.getId());
    }
}

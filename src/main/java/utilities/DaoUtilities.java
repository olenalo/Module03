package utilities;

import models.DataCell;
import models.Location;
import models.Sheet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUtilities {

    public static void insertByQuery(String sql) {
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Please provide a unique location for a sheet.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateOrRemoveByQuery(String sql) {
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataCell fetchCellBySqlQuery(String sql) {
        DataCell cell = null;
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                cell = new DataCell(
                        new Location(rs.getLong(1), rs.getLong(2)),
                        rs.getString(3),
                        rs.getLong(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cell;
    }

    public static List<DataCell> fetchCellsBySqlQuery(String sql) {
        List<DataCell> cells = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                cells.add(new DataCell(
                        new Location(rs.getLong(1), rs.getLong(2)),
                        rs.getString(3),
                        rs.getLong(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cells;
    }

    public static List<Sheet> fetchSheetsBySqlQuery(String sql) {
        List<Sheet> sheets = new ArrayList<>();
        try (Connection connection = DBCPDataSource.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                sheets.add(new Sheet(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getLong(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sheets;
    }

}

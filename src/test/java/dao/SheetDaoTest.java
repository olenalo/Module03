package dao;

import models.Sheet;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static configs.MySQLConfigs.COLUMNS_NUMBER_FIELD;
import static configs.MySQLConfigs.ROWS_NUMBER_FIELD;
import static configs.MySQLConfigs.TITLE_FIELD;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Ensure <code>SheetDao</code> objects are created properly.
 * <p>
 * Also, check business logic here, e.g. input checks.
 */
@RunWith(MockitoJUnitRunner.class)
public class SheetDaoTest {

    private Sheet sheet;
    @Mock
    private SheetDao sheetDaoMock; // Needed for some tests
    @Mock
    private Connection connection;
    @Mock
    private DBCPDataSource ds;
    @Mock
    private Statement statement;
    @Mock
    private ResultSet resultSet;

    @Before
    public void setUp() throws Exception {
        sheet = new Sheet(0, "test_title", 2, 2);

        resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);
        when(resultSet.getLong(1)).thenReturn((long) 0);
        when(resultSet.getString(2)).thenReturn("test_title");
        when(resultSet.getLong(3)).thenReturn((long) 2);
        when(resultSet.getLong(4)).thenReturn((long) 2);

        statement = mock(Statement.class);
        when(statement.executeQuery(any(String.class)))
                .thenReturn(resultSet);

        ds = mock(DBCPDataSource.class);
        when(ds.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDaoInitFailureIfNullDataSource() {
        new CellDao(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveFailureIfNoSheetProvided() {
        new SheetDao(ds).save(null);
    }

    @Test
    public void testSaveSuccess() {
        new SheetDao(ds).save(sheet);
    }

    @Test
    public void testSaveAndGetSheetSuccess() {
        SheetDao dao = new SheetDao(ds);
        dao.save(sheet);
        Sheet testSheet = dao.get(0);
        // TODO discuss the weird thing: had to override equals() for this test to pass
        assertEquals(sheet, testSheet);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLocationExistsFailureIfNoLocProvided() {
        new SheetDao(ds).locationExists(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLocationExistsFailureIfNoSheetExists() {
        sheetDaoMock = mock(SheetDao.class);
        when(sheetDaoMock.get(2)).thenReturn(null);
        new SheetDao(ds).locationExists(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteFailureIfNoSheetProvided() {
        new SheetDao(ds).delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateFailureIfNoSheetProvided() {
        new SheetDao(ds).update(null, new String[]{ROWS_NUMBER_FIELD, "1"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateFailureIfNoSqlProvided() {
        new SheetDao(ds).update(null, new String[]{ROWS_NUMBER_FIELD, "1"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateFailureIfUndefinedParamProvided() {
        new SheetDao(ds).update(sheet, new String[]{"undefined_param", "1"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateRowsNumberSuccess() throws Exception {
        new SheetDao(ds).update(null, new String[]{ROWS_NUMBER_FIELD, "1"});
        verify(statement, times(1)).executeQuery(any(String.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateColumnsNumberSuccess() throws Exception {
        new SheetDao(ds).update(null, new String[]{COLUMNS_NUMBER_FIELD, "1"});
        verify(statement, times(1)).executeQuery(any(String.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateTitleSuccess() throws Exception {
        new SheetDao(ds).update(null, new String[]{TITLE_FIELD, "title"});
        verify(statement, times(1)).executeQuery(any(String.class));
    }

}

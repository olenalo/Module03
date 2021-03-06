package dao;

import models.Sheet;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    private SheetDao daoMock; // Needed for some tests
    @Mock
    private Connection connection;
    @Mock
    private DBCPDataSource ds;
    @Mock
    private PreparedStatement statement;
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

        ds = mock(DBCPDataSource.class);
        when(ds.getConnection()).thenReturn(connection);

        statement = mock(PreparedStatement.class);
        when(connection.prepareStatement(any(String.class))).thenReturn(statement);
        when(statement.executeQuery()).thenReturn(resultSet);
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
        daoMock = mock(SheetDao.class);
        when(daoMock.get(2)).thenReturn(null);
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
    public void testUpdateFailureIfIllegalParamProvided() {
        new SheetDao(ds).update(sheet, new String[]{"illegal_param", "1"});
    }

    @Ignore("Skip till figure out a way to mock dao update() expectations (probably need to refactor the logic")
    @Test
    public void testUpdateRowsNumberSuccess() {
        daoMock.update(sheet, new String[]{ROWS_NUMBER_FIELD, "1"});
        // verify(daoMock, times(1)).updateOrRemoveByQuery(any(String.class));
    }

    @Ignore("Skip till figure out a way to mock dao update() expectations (probably need to refactor the logic")
    @Test
    public void testUpdateColumnsNumberSuccess() {
        daoMock.update(sheet, new String[]{COLUMNS_NUMBER_FIELD, "1"});
        // verify(daoMock, times(1)).updateOrRemoveByQuery(any(String.class));
    }

    @Ignore("Skip till figure out a way to mock dao update() expectations (probably need to refactor the logic")
    @Test
    public void testUpdateTitleSuccess() {
        daoMock.update(sheet, new String[]{TITLE_FIELD, "title"});
        // verify(daoMock, times(1)).updateOrRemoveByQuery(any(String.class));
    }

}

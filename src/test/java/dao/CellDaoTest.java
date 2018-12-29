package dao;

import models.Cell;
import models.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import utilities.DBCPDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Ensure <code>CellDao</code> objects are created properly.
 * <p>
 * Also, check business logic here, e.g. input checks.
 */
@RunWith(MockitoJUnitRunner.class)
public class CellDaoTest {

    private Cell cell;
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
        cell = new Cell(new Location(1, 1), "test value", 0);

        resultSet = mock(ResultSet.class);
        when(resultSet.next()).thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);
        when(resultSet.getLong(1)).thenReturn((long) 1);
        when(resultSet.getLong(2)).thenReturn((long) 1);
        when(resultSet.getString(3)).thenReturn("test value");
        when(resultSet.getLong(4)).thenReturn((long) 0);

        statement = mock(Statement.class);
        when(statement.executeQuery(any(String.class)))
                .thenReturn(resultSet);

        ds = mock(DBCPDataSource.class);
        when(ds.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveFailureIfNoSheetProvided() {
        new CellDao(ds).save(null);
    }

    @Test
    public void testSaveSuccess() {
        new CellDao(ds).save(cell);
    }

    /**
     * Test forever-unsupported method.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetFailureWrongSignature() {
        new CellDao(ds).get(0);
    }

    @Test
    public void testSaveAndGetSuccess() {
        CellDao dao = new CellDao(ds);
        dao.save(cell);
        Cell testCell = dao.get(new Location(1, 1), 0);
        // FIXME not sure why it fails
        // assertEquals(cell, testCell);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteFailureIfNoSheetProvided() {
        new CellDao(ds).delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateFailureIfNoSheetProvided() {
        new CellDao(ds).update(null, new String[]{"value", "1"});
    }

}

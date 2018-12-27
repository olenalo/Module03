package utilities;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static configs.MySQLConfigs.MIN_IDLE;
import static configs.MySQLConfigs.MAX_IDLE;
import static configs.MySQLConfigs.MAX_OPEN_STATEMENTS;

/**
 * MySQL connection pooling.
 */
public class DBCPDataSource {
    private static DBCPDataSource instance;
    private static BasicDataSource ds = new BasicDataSource();
    private static MySQLProperties mySqlProps = MySQLProperties.getInstance();

    static {
        ds.setUrl(mySqlProps.getUrl());
        ds.setUsername(mySqlProps.getUser());
        ds.setPassword(mySqlProps.getPassword());
        ds.setMinIdle(MIN_IDLE);
        ds.setMaxIdle(MAX_IDLE);
        ds.setMaxOpenPreparedStatements(MAX_OPEN_STATEMENTS);
    }

    public static DBCPDataSource getInstance() {
        if (instance == null) {
            instance = new DBCPDataSource();
        }
        return instance;
    }

    private DBCPDataSource() {
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
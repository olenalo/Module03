package configs;

public class MySQLConfigs {

    // Connection pooling
    public static final int MAX_OPEN_STATEMENTS = 100;
    public static final int MAX_IDLE = 10;
    public static final int MIN_IDLE = 5;

    // Config properties files
    public static final String MY_SQL_PROP_FILE_NAME = "mysql.properties";

    // Tables names
    public static final String SHEETS_TABLE_NAME = "sheets";
    public static final String DATA_CELLS_TABLE_NAME = "cells";

    // Misc
    public static final long ZERO_INDEX = 0;

}

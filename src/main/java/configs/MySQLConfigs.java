package configs;

public class MySQLConfigs {

    // Connection pooling
    public static final int MAX_OPEN_STATEMENTS = 100;
    public static final int MAX_IDLE = 10;
    public static final int MIN_IDLE = 5;

    // Config properties files
    public static final String MY_SQL_PROP_FILE_NAME = "mysql.properties";

    // Tables and their fields names
    public static final String SHEETS_TABLE_NAME = "sheets";
    public static final String SHEET_ID_FIELD = "sheet_id";
    public static final String COLUMNS_NUMBER_FIELD = "columns_number";
    public static final String ROWS_NUMBER_FIELD = "rows_number";
    public static final String TITLE_FIELD = "title";
    public static final String[] SHEETS_ALLOWED_MODIFIABLE_FIELDS = new String[]{COLUMNS_NUMBER_FIELD,
            ROWS_NUMBER_FIELD,
            TITLE_FIELD};

    public static final String CELLS_TABLE_NAME = "cells";
    public static final String ROW_INDEX_FIELD = "row_index";
    public static final String COLUMN_INDEX_FIELD = "column_index";
    public static final String CELL_VALUE_FIELD = "cell_value";
    public static final String[] CELLS_ALLOWED_MODIFIABLE_FIELDS = new String[]{ROW_INDEX_FIELD,
            COLUMN_INDEX_FIELD,
            CELL_VALUE_FIELD};

    // Misc
    public static final long ZERO_INDEX = 0;

}

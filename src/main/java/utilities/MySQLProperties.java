package utilities;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import static configs.MySQLConfigs.MY_SQL_PROP_FILE_NAME;

public class MySQLProperties {

    private static MySQLProperties instance;
    private String user;
    private String url;
    private String password;

    private MySQLProperties() {
        setPropValues();
    }

    public static MySQLProperties getInstance() {
        if (instance == null) {
            instance = new MySQLProperties();
        }
        return instance;
    }

    private void setPropValues() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(MY_SQL_PROP_FILE_NAME)) {
            Properties properties = new Properties();
            if (inputStream == null) {
                throw new FileNotFoundException("Property file '" + MY_SQL_PROP_FILE_NAME + "' is not found.");
            } else {
                properties.load(inputStream);
            }
            this.user = properties.getProperty("user");
            this.url = properties.getProperty("url");
            this.password = properties.getProperty("password");
            System.out.println("MySQL Properties = " + user + ", " + url + ", " + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUser() {
        return user;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }
}

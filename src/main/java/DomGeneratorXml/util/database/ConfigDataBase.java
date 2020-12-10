package DomGeneratorXml.util.database;

import com.sun.xml.internal.txw2.annotation.XmlValue;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author huyuanxin
 * @create 2020/12/10 9:31
 */
public class ConfigDataBase {
    public static Connection getSqlConnection() {
        Connection conn = null;
        try {
            InputStream inputStream = ConfigDataBase.class.getClassLoader().getResourceAsStream("config.properties");
            Properties dataBaseConfig = new Properties();
            dataBaseConfig.load(inputStream);
            String dataBaseUrl=dataBaseConfig.getProperty("DataBaseSourceUrl");
            String dataBaseUser= dataBaseConfig.getProperty("DataBaseUserName");
            String dataBasePassword=dataBaseConfig.getProperty("DataBasePassword");
            String dataBaseDriverName=dataBaseConfig.getProperty("DataBaseDriverClassName");
            Class.forName(dataBaseDriverName);
            conn = DriverManager.getConnection(dataBaseUrl, dataBaseUser, dataBasePassword);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

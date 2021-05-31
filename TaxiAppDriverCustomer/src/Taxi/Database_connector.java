package Taxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_connector   {
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/driverinfo?useSSL=false", "root", "");
        return connection;
    };

}

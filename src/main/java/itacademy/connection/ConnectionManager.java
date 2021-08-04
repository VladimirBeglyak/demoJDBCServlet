package itacademy.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL="jdbc:mysql://localhost:3306/artists";
    private static final String USER="root";
    private static final String PASSWORD="root";

    public static Connection newConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }



}

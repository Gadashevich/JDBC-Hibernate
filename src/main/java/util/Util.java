package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection()  {
        Connection connection;
        try {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      //  connection.setAutoCommit(false);
            System.out.println("Соединение успешно открыто");
        } catch (SQLException e){
            System.out.println("Произошла ошибка соединения, соединение не установлено");
            throw new RuntimeException();
        }

        return connection;
    }
}

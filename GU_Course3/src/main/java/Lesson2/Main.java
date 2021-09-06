package Lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static Connection connection;

    public static void main(String[] args) {
        System.out.println("Ciao!");
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:teachers.db");
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

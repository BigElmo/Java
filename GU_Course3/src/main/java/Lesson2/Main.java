package Lesson2;

import java.sql.*;

public class Main {

    private static Connection conn;
    private static Statement stmt;

    public static void main(String[] args) {
        System.out.println("Ciao!");
        try {
            connect();
            createTableEx();
            insertEx();
            insertEx();
            insertEx();
            readEx();
            System.out.println();
            deleteEx();
            readEx();
            dropEx();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void createTableEx() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS example (\n" +
                "    id      INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                    UNIQUE\n" +
                "                    NOT NULL,\n" +
                "    Name    TEXT    NOT NULL,\n" +
                "    Surname TEXT    NOT NULL,\n" +
                "    Age     INTEGER\n" +
                ");");
    }

    public static void insertEx() throws SQLException {
        stmt.executeUpdate("INSERT INTO example (Name, Surname) VALUES ('Bob', 'Marley');");
    }

    public static void readEx() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM example;");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columns = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }

    public static void deleteEx() throws SQLException {
        stmt.executeUpdate("DELETE FROM example WHERE id = 1;");
    }

    public static void dropEx() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS example;");
    }

    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:teachers.db");
        stmt = conn.createStatement();
    }

    public static void disconnect() {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

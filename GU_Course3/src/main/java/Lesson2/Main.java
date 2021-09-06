package Lesson2;

import java.sql.*;

public class Main {

    private static Connection conn;
    private static Statement stmt;

    public static void main(String[] args) {
        System.out.println("Ciao!");
        try {
            connect();
            ResultSet rs = stmt.executeQuery("SELECT name, surname FROM teachers WHERE id = 2;");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
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

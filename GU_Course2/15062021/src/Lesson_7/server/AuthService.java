package Lesson_7.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class AuthService {
    private static final Logger LOGGER = LogManager.getLogger(AuthService.class);
    private static Connection connection;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
//            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass) {
        String sql = String.format("SELECT nickname FROM users WHERE login = '%s' AND password = '%s'", login, pass);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException throwables) {
            LOGGER.debug(throwables.getMessage());
//            throwables.printStackTrace();
        }
        return null;
    }

    public static int getIDbyNick(String nickname) {
        String sql = String.format("SELECT id FROM users WHERE nickname = '%s'", nickname);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException throwables) {
            LOGGER.debug(throwables.getMessage());
//            throwables.printStackTrace();
        }
        return 0;
    }

    public static void addToBlackList(String nick1, String nick2) {
        String sql = String.format("INSERT INTO black_list (user_id, blocked_user_id) VALUES (%s, %s)", getIDbyNick(nick1), getIDbyNick(nick2));
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException throwables) {
            LOGGER.debug(throwables.getMessage());
//            throwables.printStackTrace();
        }
    }

    public static boolean isInBlacklist(String user, String blockedUser) {
        String sql = String.format("SELECT * FROM black_list WHERE user_id = %s AND blocked_user_id = %s", getIDbyNick(user), getIDbyNick(blockedUser));
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            LOGGER.debug(throwables.getMessage());
//            throwables.printStackTrace();
        }
        return false;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            LOGGER.debug(throwables.getMessage());
//            throwables.printStackTrace();
        }
    }

}

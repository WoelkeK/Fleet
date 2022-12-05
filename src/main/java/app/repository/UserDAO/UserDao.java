package app.repository.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserDao {

    static final String DRIVER = "jdbc:h2:~/fleet-app";
    static final String USER = "sa";
    static final String PASSWORD = "";
    static final String SQL_INSERT_DATA = "INSERT INTO USERS (ID,NICK,LOGIN,PASSWORD,CREATED) VALUES(?, ?, ?, ?, ?);";
    static final String SQL_INSERT_TABLE = "CREATE TABLE USERS(" + "ID INTEGER NOT NULL PRIMARY KEY ," + "NICK VARCHAR(30) NOT NULL, " + "LOGIN VARCHAR(30) NOT NULL," + "PASSWORD VARCHAR(50) NOT NULL," + "CREATED TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP"+")";
    static Connection connection;

    public UserDao() {

        try {
            connection = DriverManager.getConnection(DRIVER, USER, PASSWORD);
            System.out.println("Connection succesfull. ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() throws SQLException {
        PreparedStatement ps = connection.prepareStatement(SQL_INSERT_TABLE);
        ps.execute();
    }

    public void insertData(Long id, String nick, String login, String password, Timestamp created) throws SQLException {

        try (
                PreparedStatement ps = connection.prepareStatement(SQL_INSERT_DATA)) {

            ps.setLong(1, id);
            ps.setString(2, nick);
            ps.setString(3, login);
            ps.setString(4, password);
            ps.setTimestamp(5,created);
            ps.execute();
        }
    }
}

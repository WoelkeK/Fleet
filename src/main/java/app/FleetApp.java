package app;

import app.model.Users;
import app.repository.UserDAO.UserDao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

public class FleetApp {
    public static void main(String[] args) {

        Users users = new Users(1L,"crisw", "login", "password", Timestamp.from(Instant.now()));
        UserDao userDao = new UserDao();

        try {
            userDao.createTable();
            userDao.insertData(users.getId(), users.getNick(),users.getLogin(), users.getPassword(), users.getInsertTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Create: " + users);
    }
}

package app.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

        private static ConnectionManager connectionManager;
        private Connection connection;

        private ConnectionManager() {
        }

        public static ConnectionManager getInstance() {
            if (connectionManager == null) {
                connectionManager = new ConnectionManager();
            }
            return connectionManager;
        }

        public Connection getConnection() {
            try {
                if (connection == null) {
                    connection = DriverManager.getConnection("jdbc:h2:~/test;", "sa", "");
                    return connection;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

        public void closeConnection() {
            try {
                if (connection != null) {
                    if (!connection.isClosed()) {
                        connection.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

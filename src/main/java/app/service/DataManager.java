package app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.logging.Logger;

import static app.service.Constants.CREDENTIALS_ERROR;
import static app.service.Constants.DRIVER_ERROR;
import static app.service.Constants.INSERT_INSURANCE;
import static app.service.Constants.INSERT_USER;
import static app.service.Constants.INSERT_VEHICLE;
import static app.service.Constants.LOGIN;
import static app.service.Constants.PASSWORD;
import static app.service.Constants.TYP_STEROWNIKA;
import static app.service.Constants.URL;
import static app.service.Constants.URL_ERROR;
import static app.service.Constants.getTableMap;


public class DataManager {
    private static final Logger LOGGER = Logger.getLogger(DataManager.class.getName());

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;


    public DataManager() {

        try {
            Class.forName(TYP_STEROWNIKA);
        } catch (ClassNotFoundException e) {
            System.out.println("Nie odnaleziono sterownika bazy. Koniec Programu");
            System.exit(1);
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {

            if (e.getErrorCode() == URL_ERROR) {
                System.out.println("Problem komunikacji z serwerem. Niedostęny URL lub brak połączenia z siecią. Zakończenie programu.");
                System.exit(2);
            } else if (e.getErrorCode() == CREDENTIALS_ERROR) {
                System.out.println("Nieprawidłowy Login lub hasło do bazy danych. Zakończenie programu. ");
                System.exit(3);
            } else if (e.getErrorCode() == DRIVER_ERROR) {
                System.out.println("Nie znaleziono odpowiedniego sterownika bazy danych.");
                System.exit(4);
            } else {
                System.out.println(e.getErrorCode());
                e.printStackTrace();
                System.exit(5);
            }
        }
    }

    public void checkConnection() {
        try {
            if (!connection.isValid(0)) {
                System.out.println("Przerwane połaczenie z Bazą Danych. Nieoczekiwany koniec programu. ");
                System.exit(10);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("Connection is valid()");
    }

    public void createTables() {

        LOGGER.info("createTables()");

        HashMap<String, String> tables = getTableMap();

        tables.forEach((key, value) -> {

            try (
                    PreparedStatement createPreparedStatement = connection.prepareStatement(value)) {
                createPreparedStatement.execute();
                LOGGER.info("createTable() " + value);

            } catch (SQLException e) {
                if (e.getMessage().contains("42101-214")) {
                    System.out.println("Tabela: " + "* " + key + " *" + " - już istnieje, operacja pominięta. ");
//                    clearTablesData(key);

                } else {
                    System.out.println("Błąd przy tworzeniu tabeli");
                    e.printStackTrace();
                    e.getMessage();
                }
            }
        });
        LOGGER.info("createTables(...)");
    }

    public void clearTablesData(String  key) {

        try (
                PreparedStatement existPreparedStatement = connection.prepareStatement("TRUNCATE TABLE " + key)) {
            existPreparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOGGER.info("clearTables(...)");
    }

    public void insertUserData(Long id, String nick, String login, String password, Timestamp timestamp) {
        LOGGER.info("insertUserData()");
        try (
                PreparedStatement psIN = connection.prepareStatement(INSERT_USER)) {
            psIN.setLong(1, id);
            psIN.setString(2, nick);
            psIN.setString(3, login);
            psIN.setString(4, password);
            psIN.setTimestamp(5, timestamp);
            int count = psIN.executeUpdate();
            LOGGER.info("insertUserData(...)" + psIN + " " + count);
        } catch (SQLException e) {
            System.out.println("Błąd przy wstawianiu użytkownika");
            e.printStackTrace();
        }
    }

    public void insertVehicleData(Long id, String login, String brand, String model, Timestamp timestamp) {
        try (
                PreparedStatement psIU = connection.prepareStatement(INSERT_VEHICLE)) {
            psIU.setLong(1, id);
            psIU.setString(2, login);
            psIU.setString(3, brand);
            psIU.setString(4, model);
            psIU.setTimestamp(5, timestamp);
            psIU.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Błąd przy wstawianiu pojazdu");
            e.printStackTrace();
        }
    }

    public void insertInsuranceData(Long id, Long vehicleID, String insurer, float price, Timestamp timestamp) {
        try (
                PreparedStatement psIP = connection.prepareStatement(INSERT_INSURANCE)) {
            psIP.setLong(1, id);
            psIP.setLong(2, vehicleID);
            psIP.setString(3, insurer);
            psIP.setFloat(4, price);
            psIP.setTimestamp(5, timestamp);
            psIP.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Błąd przy wstawianiu polisy");
            e.printStackTrace();
        }
    }

//    public Identifiers insertIdentifiers(Long U_Id, Long V_Id, Long I_Id) {
//
//        Identifiers identifiers = new Identifiers();
//        identifiers.setU_Id(U_Id);
//        identifiers.setV_Id(U_Id);
//        identifiers.setI_Id(V_Id);
//
//    }
}


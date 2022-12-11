package app.service;

import java.util.HashMap;

public class Constants {

    public static final String TYP_STEROWNIKA = "org.h2.Driver";
    public static final String URL = "jdbc:h2:~/fleet-app";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";
    public static final int DRIVER_ERROR = 0;
    public static final int URL_ERROR = 1;
    public static final int CREDENTIALS_ERROR = 2;

//    public static HashMap<Integer, TableDdlSql> getTableMap2() {
//        class TableDdlSql {
//            private String tableName;
//            private String tableCreateSql;
//
//    }

    public static HashMap<String, String> getTableMap() {

        HashMap<String, String> tables = new HashMap<>();

        tables.put("USERS", CREATE_USERS_TABLE);
        tables.put("VEHICLES", CREATE_VEHICLES_TABLE);
        tables.put("INSURANCES", CREATE_INSURANCES_TABLE);
        return tables;
    }

    static final String INSERT_USER = "INSERT INTO USERS (U_ID, NICK, LOGIN, PASSWORD, CREATED) VALUES(?, ?, ?, ?, ?);";
    static final String INSERT_VEHICLE = "INSERT INTO VEHICLES (V_ID, LOGIN, BRAND, MODEL, CREATED) VALUES(?, ?, ?, ?, ?);";
    static final String INSERT_INSURANCE = "INSERT INTO INSURANCES (I_ID, VEHICLE_ID, INSURER, PRICE, CREATED) VALUES(?, ?, ?, ?, ?);";

    static final String SELECT_USER = "SELECT U_DU,NICK, LOGIN, PASSWORD FROM USERS WHERE U_ID = ?";
    static final String SELECT_VEHICLE = "SELECT FROM VEHICLES V JOIN USERS U ON V.LOGIN = U.LOGIN";
    static final String SELECT_INSURANCE = "SELECT I_ID, VEHICLE_ID, INSURER, PRICE, CREATED FROM INSURANCES WHERE I_ID = ?";


    static final String CREATE_USERS_TABLE = "CREATE TABLE USERS(" +
            "U_ID NUMBER NOT NULL PRIMARY KEY," +
            "NICK CHAR(20) NOT NULL," +
            "LOGIN CHAR(20) NOT NULL UNIQUE," +
            "PASSWORD CHAR(50) NOT NULL," +
            "CREATED TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)";

    static final String CREATE_VEHICLES_TABLE =
            "CREATE TABLE VEHICLES(" +
                    "V_ID NUMBER NOT NULL PRIMARY KEY, " +
                    "LOGIN CHAR(20) NOT NULL, " +
                    "BRAND CHAR(20) NOT NULL, " +
                    "MODEL CHAR(50) NOT NULL, " +
                    "CREATED TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, " +
                    "CONSTRAINT FK_USERS_LOGIN FOREIGN KEY (LOGIN) REFERENCES USERS(LOGIN))";

    static final String CREATE_INSURANCES_TABLE =
            "CREATE TABLE INSURANCES(" +
                    "I_ID NUMBER NOT NULL PRIMARY KEY," +
                    "VEHICLE_ID NUMBER NOT NULL," +
                    "INSURER CHAR(40) NOT NULL," +
                    "PRICE FLOAT NOT NULL," +
                    "CREATED TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)";

}

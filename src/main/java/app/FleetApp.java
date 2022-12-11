package app;

import app.service.DataManager;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class FleetApp {
    public static void main(String[] args) {

        DataManager dataManager =  new DataManager();
        dataManager.createTables();
        dataManager.checkConnection();
//        dataManager.insertUserData(1L, "nick1", "login1", "password1", Timestamp.valueOf(LocalDateTime.now()));
//        dataManager.insertVehicleData(1L, "login1", "brand1", "model1", Timestamp.valueOf(LocalDateTime.now()));
//        dataManager.insertInsuranceData(1L,123456789L, "INSURER", 102.2f, Timestamp.valueOf(LocalDateTime.now()));
        // odczytać select ID i sparować a następnie ustawić PK i FK w tabeli Identifires?
    }
}

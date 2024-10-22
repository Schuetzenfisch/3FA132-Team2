package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    //Aus properties ziehen!
    private static final String URL = "jdbc:mariadb://localhost:3306/schulprojektdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "#Sim06Kolli-workspace";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void testConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Verbindung zur Datenbank erfolgreich!");
        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung zur Datenbank:");
            e.printStackTrace();
        }
    }
}

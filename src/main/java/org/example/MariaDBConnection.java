package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBConnection {
    public static void main(String[] args) {
        // URL im Format: jdbc:mariadb://[HOST]:[PORT]/[DATENBANKNAME]
        String url = "jdbc:mariadb://localhost:3306/schulprojektdb";
        String user = "root";
        String password = "#Sim06Kolli-workspace";

        try {
            // Verbindung herstellen
            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Erfolgreich mit der MariaDB-Datenbank verbunden!");
            }

            // Verbindung schließen (optional, aber empfohlen)
            connection.close();

        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung zur Datenbank:");
            e.printStackTrace();
        }
    }
}

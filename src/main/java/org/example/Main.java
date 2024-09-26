package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mariadb://<hostname>:<port>/<database>";
    private static final String USER = "<username>";
    private static final String PASSWORD = "<password>";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Verbindung erfolgreich hergestellt.");

        } catch (SQLException e) {
            System.err.println("Fehler beim Herstellen der Verbindung: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Verbindung erfolgreich geschlossen.");
                } catch (SQLException e) {
                    System.err.println("Fehler beim Schließen der Verbindung: " + e.getMessage());
                }
            }
        }
    }
}

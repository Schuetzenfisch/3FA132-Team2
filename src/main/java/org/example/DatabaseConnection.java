package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection implements IDatabaseConnection {

    private Connection connection;

    // opens connection to db
    @Override
    public IDatabaseConnection openConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/deineDatenbank";
            String username = "root";
            String password = "passwort";

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Verbindung erfolgreich geöffnet!");
        } catch (SQLException e) {
            System.err.println("Verbindung fehlgeschlagen: " + e.getMessage());
        }
        return this;
    }

    // create all tables
    @Override
    public void createAllTables() {
        try (Statement stmt = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "username VARCHAR(50) NOT NULL, "
                    + "email VARCHAR(100) NOT NULL)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Tabellen erfolgreich erstellt!");
        } catch (SQLException e) {
            System.err.println("Fehler beim Erstellen der Tabellen: " + e.getMessage());
        }
    }

    // deletes all tables
    @Override
    public void dropAllTables() {
        try (Statement stmt = connection.createStatement()) {
            String dropTableSQL = "DROP TABLE IF EXISTS users";
            stmt.executeUpdate(dropTableSQL);
            System.out.println("Tabellen erfolgreich gelöscht!");
        } catch (SQLException e) {
            System.err.println("Fehler beim Löschen der Tabellen: " + e.getMessage());
        }
    }

    // removes all tables
    @Override
    public void removeAllTables() {
        try (Statement stmt = connection.createStatement()) {
            String deleteDataSQL = "DELETE FROM users";
            stmt.executeUpdate(deleteDataSQL);
            System.out.println("Tabellen erfolgreich geleert!");
        } catch (SQLException e) {
            System.err.println("Fehler beim Leeren der Tabellen: " + e.getMessage());
        }
    }

    // closes connection
    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Verbindung erfolgreich geschlossen!");
            } catch (SQLException e) {
                System.err.println("Fehler beim Schließen der Verbindung: " + e.getMessage());
            }
        }
    }
}

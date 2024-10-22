package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mariadb://localhost:3306/schulprojektdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "#Sim06Kolli-workspace";

    private static DatabaseConnection instance;

    private Connection connection;

    private DatabaseConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Fehler bei der Verbindung zur Datenbank:");
            throw new SQLException(e);
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

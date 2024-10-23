package org.example.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJUnit {

    @Test
    public void testDatabaseConnection() {
        String url = "jdbc:mariadb://localhost:3307/schulprojektdb";
        String user = "root";
        String password = "Ilayda3009";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Test: Verbindung sollte nicht null sein
            Assertions.assertNotNull(connection, "Die Verbindung sollte nicht null sein.");
        } catch (SQLException e) {
            Assertions.fail("Fehler bei der Verbindung zur MariaDB: " + e.getMessage());
        }
    }
}

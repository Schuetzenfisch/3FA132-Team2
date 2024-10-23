package org.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;

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
            assertNotNull("Die Verbindung sollte nicht null sein.", connection);
        } catch (SQLException e) {
            fail("Fehler bei der Verbindung zur MariaDB: " + e.getMessage());
        }
    }
}

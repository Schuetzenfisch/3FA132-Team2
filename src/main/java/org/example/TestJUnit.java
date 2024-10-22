package org.example;

import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.fail;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJUnit {

    @Test
    public void testDatabaseConnection() {
        String url = "jdbc:mariadb://localhost:3306/schulprojektdb";
        String user = "root";
        String password = "#Sim06Kolli-workspace";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Test: Verbindung sollte nicht null sein
            assertNotNull(connection, "Die Verbindung sollte nicht null sein.");
        } catch (SQLException e) {
            fail("Fehler bei der Verbindung zur MariaDB: " + e.getMessage());
        }
    }
}

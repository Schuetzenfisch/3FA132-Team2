package org.example.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection dbConfig = DatabaseConnection.getInstance();
            Connection connection = dbConfig.getConnection();

            if (connection != null) {
                System.out.println("Verbindung zur Datenbank erfolgreich!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


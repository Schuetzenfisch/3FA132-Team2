package org.example.database;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConfig = new DatabaseConnection();

        dbConfig.testConnection();

    }
}

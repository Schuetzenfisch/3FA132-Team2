package org.example;

import org.example.model.ICustomer;
import org.example.model.IDatabaseConnection;

import java.sql.*;
import java.util.*;

public class CustomerJdbcRepository implements ICustomer {
    private Connection connection;

    public CustomerJdbcRepository(IDatabaseConnection dbConnection) throws SQLException {
        this.connection = (Connection) dbConnection.openConnection();
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public void setId(int id) {
        // Implementierung zur Setzung der ID
    }

    @Override
    public String getName() {
        // Rückgabe des Kundennamens
        return null; // Dummy-Wert
    }

    @Override
    public void setName(String name) {
        // Implementierung zur Setzung des Kundennamens
    }

    public void erstelleKunde(ICustomer kunde) throws SQLException {
        String sql = "INSERT INTO Kunde (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, kunde.getName());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    kunde.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public ICustomer findeKundeNachId(int id) throws SQLException {
        String sql = "SELECT * FROM Kunde WHERE UUID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    ICustomer kunde = new CustomerJdbcRepository(connection);
                    kunde.setId(resultSet.getInt("uuid"));
                    kunde.setName(resultSet.getString("name"));
                    return kunde;
                } else {
                    return null;
                }
            }
        }
    }

    public void aktualisiereKunde(ICustomer kunde) throws SQLException {
        String sql = "UPDATE Kunde SET name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, kunde.getName());
            statement.setInt(2, kunde.getId());
            statement.executeUpdate();
        }
    }

    public void loescheKunde(int id) throws SQLException {
        String sql = "DELETE FROM Kunde WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

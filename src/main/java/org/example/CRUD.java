package org.example.dao;

import org.example.model.ICustomer;
import org.example.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD {

    // Create
    public void createCustomer(ICustomer customer) throws SQLException {
        String query = "INSERT INTO customers (first_name, last_name, birth_date, gender) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setDate(3, Date.valueOf(customer.getBirthDate()));
            stmt.setString(4, customer.getGender().name());
            stmt.executeUpdate();
        }
    }

    // Read
    public ICustomer getCustomerById(Long id) throws SQLException {
        String query = "SELECT * FROM customers WHERE id = ?";
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setBirthDate(rs.getDate("birth_date").toLocalDate());
                customer.setGender(ICustomer.Gender.valueOf(rs.getString("gender")));
                return customer;
            }
        }
        return null;
    }

    // Update
    public void updateCustomer(ICustomer customer) throws SQLException {
        String query = "UPDATE customers SET first_name = ?, last_name = ?, birth_date = ?, gender = ? WHERE id = ?";
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setDate(3, Date.valueOf(customer.getBirthDate()));
            stmt.setString(4, customer.getGender().name());
            stmt.setLong(5, customer.getId());
            stmt.executeUpdate();
        }
    }

    // Delete
    public void deleteCustomer(Long id) throws SQLException {
        String query = "DELETE FROM customers WHERE id = ?";
        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    // List all customers
    public List<ICustomer> getAllCustomers() throws SQLException {
        List<ICustomer> customers = new ArrayList<>();
        String query = "SELECT * FROM customers";
        try (Connection connection = ConnectionConfig.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setBirthDate(rs.getDate("birth_date").toLocalDate());
                customer.setGender(ICustomer.Gender.valueOf(rs.getString("gender")));
                customers.add(customer);
            }
        }
        return customers;
    }
}

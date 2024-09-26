package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    try{
        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://",
                "",
                ""
        );
    } catch(SQLException e) {

    }

}

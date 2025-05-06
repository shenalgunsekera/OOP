package com.OOP.OOP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/oop";
    private static final String USER = "root"; // Change if necessary
    private static final String PASSWORD = ""; // Your MySQL password

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
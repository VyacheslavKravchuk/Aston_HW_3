package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String USER = "postgres";
    private static final String PASSWORD = "klerik87&";
    private static final String URL = "jdbc:postgresql://localhost:5432/aston";

    public ConnectionManager() {
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER,PASSWORD);
    }
}
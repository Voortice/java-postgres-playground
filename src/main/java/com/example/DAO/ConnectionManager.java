package com.example.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String SENHA = "";
    private static final String USUARIO = "gitpod";
    private static final String POSTGRESQL_URL = "jdbc:postgresql://localhost/postgres";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(POSTGRESQL_URL, USUARIO, SENHA);
    } 
}
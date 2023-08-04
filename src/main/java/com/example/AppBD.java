package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBD {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("Não foi possivel conectar a biblioteca para acesso ao banco de dados" + e.getMessage());
        }

        Statement statement = null;
        try (var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "");) {
            System.out.println("Conexão com o banco de dados realizada com sucesso");

            statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while(result.next()){
                System.out.printf("id: %d Nome: %s UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }    
        }
         catch (SQLException e) {
            if (statement == null)
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados" + e.getMessage());
            else
            System.err.println("Não foi possivel realizar a consulta ao banco de dados" + e.getMessage());
        }  
    }
}

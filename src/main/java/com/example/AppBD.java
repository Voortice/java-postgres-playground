package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBD {
    private static final String SENHA = "";
    private static final String USUARIO = "gitpod";
    private static final String POSTGRESQL_URL = "jdbc:postgresql://localhost/postgres";
    private Connection conn;

    public static void main(String[] args) {
        new AppBD();
    }

    public AppBD(){
        try (var conn = getConnection()){
            carregarDriveJDBC();
            listarEstados();  
            localizarEstado("TO");
        }
        catch (SQLException e) {
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados" + e.getMessage());
        }
    }

    private void localizarEstado(String uf) {

    }

    private void listarEstados() {
        Statement statement = null;
        try (var conn = getConnection()) {
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

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(POSTGRESQL_URL, USUARIO, SENHA);
    } 

    private void carregarDriveJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.err.println("Não foi possivel conectar a biblioteca para acesso ao banco de dados" + e.getMessage());
        }
    }
}

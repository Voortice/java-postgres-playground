package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBD {
    private static final String SENHA = "";
    private static final String USUARIO = "gitpod";
    private static final String POSTGRESQL_URL = "jdbc:postgresql://localhost/postgres";

    public static void main(String[] args) {
        new AppBD();
    }

    public AppBD(){
        try (var conn = getConnection()){
            carregarDriveJDBC();
            listarEstados(conn);  
            localizarEstado(conn, "TO");
        }
        catch (SQLException e) {
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados" + e.getMessage());
        }
    }

    private void localizarEstado(Connection conn, String uf) {
        try{
            var sql = "select * from estado where uf = ?";
            var statement = conn.prepareStatement(sql);
            System.out.println(sql);
            statement.setString(1, uf);
            var result = statement.executeQuery();
            if(result.next()){
                System.out.printf("id: %d Nome: %s UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
        } catch(SQLException e){
            System.err.println("Erro ao executar a consulta SQL" + e.getMessage());
        }
        
    }

    private void listarEstados(Connection conn2) {
        try (var conn = getConnection()) {
            System.out.println("Conexão com o banco de dados realizada com sucesso");
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while(result.next()){
                System.out.printf("id: %d Nome: %s UF: %s \n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }    
        }
         catch (SQLException e) {
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

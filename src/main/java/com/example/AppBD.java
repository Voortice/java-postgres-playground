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
            
            var marca = new Marca();
            marca.setId(2L);

            var produto = new Produto();
            produto.setId(204L);
            produto.setMarca(marca);
            produto.setNome("Produto alterado");
            produto.setValor(90);

            //inserirProduto(conn, produto);
            alterarProduto(conn, produto);
            excluirProduto(conn, 202L);
            listarDadosTabela(conn, "produto");
        }
        catch (SQLException e) {
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados" + e.getMessage());
        }
    }

   private void excluirProduto(Connection conn, long id) {
        var sql = "delete from produto where id = ?";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            if(statement.executeUpdate() == 1)
            System.out.println("Produto excluido com sucesso");
            else System.out.println("Nenhum produto foi excluido");
        } catch (SQLException e) {
            System.err.println("Erro ao excluir o produto: " + e.getMessage());
        }
    }

private void inserirProduto(Connection conn, Produto produto) {
        var sql = "insert into produto (nome, marca_id, valor) values (?, ?, ?)";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro na realização da consulta " + e.getMessage());
        };
    }

    private void alterarProduto(Connection conn, Produto produto) {
        var sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ?";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro na alteração do produto " + e.getMessage());
        };
    }

private void listarDadosTabela(Connection conn, String tabela) {
        var sql = "select * from " + tabela;
        System.out.println(sql);
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);

            var metadata = result.getMetaData();
            int cols = metadata.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));
            }
            System.out.println();

            while(result.next()){
                
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Erro na realização da consulta " + e.getMessage());
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

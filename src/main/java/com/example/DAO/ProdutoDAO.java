package com.example.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import com.example.model.Produto;

public class ProdutoDAO extends DAO {

    public ProdutoDAO(Connection conn) {
        super(conn);
    }
    
    public void excluir(long id) {
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

    private void inserir(Produto produto) {
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

    public void alterar(Produto produto) {
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
}

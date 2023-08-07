package com.example;

import java.sql.SQLException;
import java.sql.Statement;

import com.example.DAO.ConnectionManager;
import com.example.DAO.DAO;
import com.example.DAO.EstadoDAO;
import com.example.DAO.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppBD {
    public static void main(String[] args) {
        new AppBD();
    }

    public AppBD(){
        try (var conn = ConnectionManager.getConnection()){
            carregarDriveJDBC();

            var estadoDAO = new EstadoDAO(conn);
            var listaEstados = estadoDAO.listar();
            for (var estado : listaEstados) {
                System.out.println(estado);
            }
            estadoDAO.localizar("TO");
            
            var marca = new Marca();
            marca.setId(2L);

            //var produto = new Produto();
            //produto.setId(204L);
            //produto.setMarca(marca);
            //produto.setNome("Produto alterado");
            //produto.setValor(90);

            //inserirProduto(conn, produto);
            //var produtoDAO = new ProdutoDAO(conn);
            //produtoDAO.alterar(produto);
            //produtoDAO.excluir(202L);

            //var dao = new DAO(conn);
            //dao.listar("produto");
        }
        catch (SQLException e) {
            System.err.println("Não foi possivel carregar a biblioteca para acesso ao banco de dados" + e.getMessage());
        }
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

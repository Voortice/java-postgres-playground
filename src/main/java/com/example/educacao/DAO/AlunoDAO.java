package com.example.educacao.DAO;
import com.example.DAO.DAO;
import com.example.educacao.model.Aluno;

public class AlunoDAO extends DAO{
    public void insert(Aluno aluno){
        var sql = "insert into aluno {nome} values (?)";
        var statement = 
    }
}

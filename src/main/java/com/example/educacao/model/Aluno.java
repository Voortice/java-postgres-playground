package com.example.educacao.model;

public class Aluno {
    private Integer matricula;
    private String nome;
    private double nota1, nota2, nota3;

    public Integer getMatricula() {
        return matricula;
    }
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public double calculaMedia(){
        return (nota1 + nota2 + nota3)/3;
    }
}

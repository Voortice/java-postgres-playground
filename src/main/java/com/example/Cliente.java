package com.example;

public class Cliente {
    private String nome; 
    private double renda;
    private char sexo;
    private int anoNascimento;
    private boolean especial = false;

    public Cliente(){
        System.out.println("Criando um novo cliente sem parametros");
    }

    public Cliente(double renda, char sexo, int anoNascimento, boolean especial){
        System.out.println("Criando um novo cliente com parametros");
        this.renda = renda;
        this.sexo = sexo;
        this.anoNascimento = anoNascimento;
        this.especial = especial;
    }

    public double getRenda() {
        return renda;
    }
    public char getSexo() {
        return sexo;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setRenda(double renda) {
        if(renda > 0){
            this.renda = renda;
        }else{
            System.out.println("A renda precisa ser positiva");
        }
    }
    
    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F'){
            this.sexo = sexo;
        }else{
            System.out.println("Insira um sexo valido");
        }
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

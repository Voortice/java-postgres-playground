package com.example;

public class AppClasses {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setRenda(1850);
        cliente.setAnoNascimento(1990);
        cliente.setSexo('M');
        System.out.println("Renda " + cliente.getRenda());
        System.out.println("Sexo " + cliente.getSexo());
        System.out.println("Ano de nascimento " + cliente.getAnoNascimento());
    }
}

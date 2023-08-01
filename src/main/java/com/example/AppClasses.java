package com.example;

public class AppClasses {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Manoel");
        cliente.setRenda(1850);
        cliente.setAnoNascimento(1990);
        cliente.setSexo('M');
        System.out.println("O nome do cliente é " + cliente.getNome());
        System.out.println("Renda " + cliente.getRenda());
        System.out.println("Sexo " + cliente.getSexo());
        System.out.println("Ano de nascimento " + cliente.getAnoNascimento());
    }
}

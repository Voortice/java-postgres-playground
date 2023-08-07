package com.example;
import java.util.Scanner;

import com.example.model.Cliente;

public class AppScanner {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        cliente.setNome(scanner.nextLine());

        System.out.println("Digite a sua renda: ");
        cliente.setRenda(scanner.nextDouble());

        System.out.println("Digite o ano do seu nascimento: ");
        cliente.setAnoNascimento(scanner.nextInt());

        scanner.nextLine();
        System.out.println("Digite o seu sexo: ");
        String sexo = scanner.nextLine();
        cliente.setSexo(sexo.charAt(0));

        System.out.println("O nome do cliente é " + cliente.getNome());
        System.out.println("Renda " + cliente.getRenda());
        System.out.println("Sexo " + cliente.getSexo());
        System.out.println("Ano de nascimento " + cliente.getAnoNascimento());
    }
}

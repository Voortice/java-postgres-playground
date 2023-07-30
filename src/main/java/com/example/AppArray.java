package com.example;

import java.util.Arrays;

public class AppArray {
    public static void main(String[] args) {
        int vetor[] = new int[5];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = 100*(i+1);
        }
        System.out.println(Arrays.toString(vetor));

        double matriz[][] = new double[3][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i*matriz[i].length+j+1;
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j]);
            }
            System.out.println();
        }
    }
}

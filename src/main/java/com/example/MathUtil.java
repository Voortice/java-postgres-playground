package com.example;

public class MathUtil {
    static int mdc(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        int maior = Math.max(a, b);
        b = Math.min(a, b);
        a = maior;

        if (b > 0 && a % b == 0)
            return b;
        if (b == 0)
            return Math.abs(a);
        
        return mdc(a-b,b);
    }

    static int mdc(int ...valores){
        if(valores == null){
            throw new NullPointerException("É necessario passar valores diferentes de nulo para o calculo do MDC");
        }

        if(valores.length == 0)
            throw new ArrayIndexOutOfBoundsException("Não foi passado nenhum valor para o calculo do MDC");
    
        int a = valores[0];
        for (int b : valores) {
            a = mdc(a, b);
        }
        return a;
    }
}

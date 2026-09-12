package com.eliascastro.screenmatch.exercicios;

import java.util.Scanner;

public class trycatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number01;
        int number02;
        int resultado;

            System.out.println("Digite um numero : ");
            number01 = sc.nextInt();
            System.out.println("Digite OUTRO numero : ");
            number02 = sc.nextInt();

            resultado = divisaoInteira(number01,number02);


        System.out.println(resultado);



        sc.close();
    }

    public static int divisaoInteira(int n1, int n2){
        try {
            return n1/n2;
        }
        catch (ArithmeticException e){
            System.out.println("Erro: " + e.getMessage());
            return 0;
        }
    }
}

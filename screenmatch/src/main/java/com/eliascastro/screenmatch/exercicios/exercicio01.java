package com.eliascastro.screenmatch.exercicios;

import java.util.Scanner;

public class exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double media = 0;
        int qtdNotas = 2;
        System.out.println("Qual o seu nome? ");
        String leitura = sc.nextLine();

        System.out.println("Bem vindo " + leitura + "!");


        System.out.println("Qual seu filme favorito? ");
        String filmeFavorito = sc.nextLine();

        for (int i = 0; i < qtdNotas; i++) {
            System.out.println("Digite a nota deste filme: ");
            media += sc.nextDouble();
        }

        System.out.println("A media de notas deste filme é: " + media/qtdNotas);


        sc.close();
    }
}

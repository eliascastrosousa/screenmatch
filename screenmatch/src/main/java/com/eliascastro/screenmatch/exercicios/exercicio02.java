package com.eliascastro.screenmatch.exercicios;

import java.util.Random;
import java.util.Scanner;

public class exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroSorteado = new Random().nextInt(100);
        int numeroTentativas = 0;
        int numeroDigitado = 0;
        System.out.println("=================== BEM VINDO AO JOGO DA ADVINHAÇÃO!!! =======================");
        System.out.println("Você possui 5 tentativas para descobrir qual o numero secreto!\nVamos lá?\n");

        while (numeroTentativas <7){
            System.out.println("Digite um numero: ");
            numeroDigitado = sc.nextInt();
            numeroTentativas++;

            if (numeroDigitado == numeroSorteado){
                System.out.println("Parabéns você Acertou!!");
                break;

            }else if(numeroSorteado < numeroDigitado) {
                System.out.println("MENOS!");
            }else if (numeroSorteado > numeroDigitado){
                System.out.println("É MAIOR!!");
            }
        }
        if (numeroTentativas == 7 && numeroSorteado != numeroDigitado){
            System.out.println("INFELIZMENTE VOCÊ NAO CONSEGUIU ACERTAR! QUÁ QUÁ QUÁAAAA");
            System.out.println("O numero SORTEADO é o: "+numeroSorteado);
        }




        sc.close();
    }
}

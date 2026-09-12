package com.eliascastro.screenmatch.exercicios;

import java.util.Scanner;

public class desafio_contabancaria {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //VARIAVEIS
        String nome = "Elias Castro Sousa Junior";
        String tipoConta = "Corrente";
        double saldoAtual = 0;
        int numDigitado = 0;

        System.out.println("*******************************");
        System.out.println("Dados iniciais do Cliente: \n");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo Conta: " + tipoConta);
        System.out.println("Saldo Inicial: "+ saldoAtual);
        System.out.println("*******************************\n\n");


        do {
            System.out.println("\n\nOperações\n");

            System.out.println("1 - Consultar Saldo: ");
            System.out.println("2 - Receber valor: ");
            System.out.println("3 - Transferir Valor: ");
            System.out.println("4 - Sair\n");

            System.out.println("Digite aqui: ");
            numDigitado = sc.nextInt();

            switch(numDigitado) {
                case 1:
                    System.out.println("*********** SALDO **************");
                    System.out.println("Saldo é de: " + saldoAtual);
                    System.out.println("********************************");

                    break;
                case 2:
                    System.out.println("*********** RECEBER VALOR **************");
                    System.out.println("Digite o valor a receber: ");
                    double receber = sc.nextDouble();
                    saldoAtual += receber;
                    if (saldoAtual >= receber){
                        System.out.println("Valor recebido com sucesso! Saldo atual: " + saldoAtual);

                    }else {
                        System.out.println("Não foi possivel completar a transação. Tente novamente!");
                    }
                    System.out.println("*************************************************************");

                    break;
                case 3:
                    System.out.println("*********** TRANSFERIR VALOR **************");
                    System.out.println("Digite o valor a transferir: ");
                    double saldoTransferido = sc.nextDouble();
                    if(saldoAtual >= saldoTransferido){
                        saldoAtual -= saldoTransferido;
                        System.out.println("Valor transferido com sucesso! Saldo atual: " + saldoAtual);


                    }else {
                        System.out.println("Não foi possivel completar a transação. Tente novamente!");
                    }
                    System.out.println("*************************************************************");

                    break;

                default:
                    System.out.println("4 - SAINDO... ");
            }
        }while (numDigitado != 4);


        sc.close();
    }
}

package com.eliascastro.screenmatch.exercicios.desafioCompras;


import java.util.Collections;
import java.util.Scanner;

public class DesafioComprasMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String descricao;
        double valorDaCompra;
        int sair = 1;

        System.out.println("Digite o  limite do cartão: ");
        CartaoDeCredito cartao = new CartaoDeCredito(sc.nextDouble());

        System.out.println(cartao);

        while(sair != 0){
            System.out.println("\nDigite a descricao da compra: ");
            descricao = sc.next();

            System.out.println("Digite o valor da compra: ");
            valorDaCompra = sc.nextDouble();

            if (cartao.getSaldo() > valorDaCompra) {
                cartao.lancaCompra(new Compra(descricao, valorDaCompra));
                System.out.println("Compra realizada !");
                System.out.println("Digite 0 para sair ou 1 para continuar");

                if (sc.nextInt() == 0){
                    sair = 0;
                }

            }else {
                System.out.println("Saldo insuficiente.");
                sair = 0;
            }

        }
        Collections.sort(cartao.getCompras());
        System.out.println(cartao);




        sc.close();
    }
}

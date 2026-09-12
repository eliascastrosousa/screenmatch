package com.eliascastro.screenmatch.exercicios.ApiCEP;

import java.io.IOException;
import java.util.Scanner;

public class CepPrincipal {
    public static void main(String[] args) throws IOException {
        ConsultaCEP consultaCEP = new ConsultaCEP();
        Scanner sc = new Scanner(System.in);
        GeradorArquivo novoArquivo = new GeradorArquivo();
        System.out.println("Digite o CEP: ");
        var leitura = sc.nextLine();

        try {
            Endereco endereco = consultaCEP.buscaEndereco(leitura);
            System.out.println(endereco);
            novoArquivo.geradorArquivoJson(endereco);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }



    }
}

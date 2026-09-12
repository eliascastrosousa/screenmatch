package com.eliascastro.screenmatch.minhasmusicas;


import java.util.*;

public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Musica[] musica = new Musica[3];

        String titulo;
        String album;
        String cantor;
        String genero;

        int maisCurtida = 0 ;
        int maisReproduzida = 0;


        System.out.println("Bem vindo ao Screen Music");
        System.out.println("Comece cadastrando 3 musicas:  ");

        for (int i = 0; i < 3; i++) {
            System.out.println("\nDigite o nome da musica: ");
            titulo = sc.nextLine();
            System.out.println("Digite o nome do Album: ");
            album = sc.nextLine();
            System.out.println("Digite o nome do cantor ou banda: ");
            cantor = sc.nextLine();
            System.out.println("Digite o Genero: ");
            genero = sc.nextLine();

            musica[i] = new Musica(titulo, album, cantor, genero);

            if (musica[i].getTitulo().equals(titulo) && musica[i].getAlbum().equals(album)){
                System.out.println("\nCadastro realizado com sucesso...");
            }

            int qtdCurtidas = new Random().nextInt(500);
            int qtdReproducoes = new Random().nextInt(500, 2000);

            for (int j = 0; j < qtdCurtidas; j++) {
                musica[i].curtiu();
            }
            for (int j = 0; j < qtdReproducoes; j++) {
                musica[i].reproduziu();
            }
        }


        if (Arrays.stream(musica).count() > 2){
            System.out.println("\nMusicas Cadastradas com sucesso!");
        }

        /*
        for (int i = 0; i < 3; i++) {
            System.out.printf("\n\nMusica: %s do Album %s Cantor: %s Genero: %s, posicao: %s\n",
                    musica[i].getTitulo(),
                    musica[i].getAlbum() ,
                    musica[i].getCantor() ,
                    musica[i].getGenero(), i );
        }
        */

        for (int i = 1; i <= 2; i++) {
            if (musica[i].getCurtidas() > musica[i-1].getCurtidas()) {
                maisCurtida = i;
            }
            else {
                maisCurtida = i-1;
            }
        }

        System.out.println("\n====================== ********* =========================");

        System.out.printf("A musica mais curtida do mês é: %s do Cantor/banda: %s ",
                musica[maisCurtida].getTitulo(),
                musica[maisCurtida].getCantor());

        System.out.printf("\nE a musica mais reproduzida do mês é: %s do Cantor: %s",
                musica[maisReproduzida].getTitulo(),
                musica[maisReproduzida].getCantor());

        System.out.println("\n====================== ********* =========================");

        sc.close();
    }



}

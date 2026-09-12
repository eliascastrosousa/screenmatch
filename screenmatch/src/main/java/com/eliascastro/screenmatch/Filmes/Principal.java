package com.eliascastro.screenmatch.Filmes;

import com.eliascastro.screenmatch.Filmes.calculos.TituloOMDB;
import com.eliascastro.screenmatch.exercicios.Carro;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        var filme01 = new Filme("Cloverfild: Monstro", 2008);
        filme01.setDuracaoEmMinutos(90);
        filme01.setDiretor("Matt Reves");
        filme01.avalia(7);

        var filme02 = new Filme("rua cloverfield 10", 2016);
        filme02.setDuracaoEmMinutos(113);
        filme02.setDiretor("Dan Trachtenberg");
        filme02.avalia(7.2);

        var filme03 = new Filme("O Paradoxo Cloverfield", 2018);
        filme03.setDuracaoEmMinutos(112);
        filme03.setDiretor("Julius Onah");
        filme03.avalia(5.5);

        ArrayList<Filme> listaFilmes = new ArrayList<>();
        listaFilmes.add(filme01);
        listaFilmes.add(filme02);
        listaFilmes.add(filme03);

        System.out.println("Tamanho da lista: " + listaFilmes.size());
        System.out.println("Primeiro filme: " + listaFilmes.getFirst().getNome());

        System.out.println(listaFilmes);
        System.out.println(listaFilmes.getFirst().toString());

        // 1. Create an HttpClient instance
        HttpClient client = HttpClient.newHttpClient();



        System.out.println("Digite o nome do filme: ");
        String filme = sc.nextLine();
        try {
            // 2. Build the GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://www.omdbapi.com/?t=" + filme.replace(" ", "+") + "&apikey=86023a29"))
                    .GET() // Default method, optional
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());


            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOMDB TituloOMDB = gson.fromJson(response.body(), TituloOMDB.class);


            System.out.println(TituloOMDB);
            Titulo titulo = new Titulo(TituloOMDB);
            System.out.println(titulo);

            FileWriter filmeTXT = new FileWriter("arquivoFilme.txt");
            filmeTXT.write(titulo.toString());
            filmeTXT.close();

        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro.");
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Erro de caracteres: " + e);

        } catch (Exception e) {
            System.out.println("aconteceu algo " + e);
        }

        sc.close();
    }



}

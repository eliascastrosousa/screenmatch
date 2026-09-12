package com.eliascastro.screenmatch.exercicios.desafioGravacaoFilmes;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        int numDigitado = 0;
        String busca = "";
        List<Titulo> titulosBuscados = new ArrayList<>();
        File arquivo = new File("filmes.json");

        HttpClient client = HttpClient.newHttpClient();
        String endereco = "http://www.omdbapi.com/?t=";

        System.out.println("\n\nBem vindo ao Busca Filme\n");

        while (!busca.equalsIgnoreCase("Sair")) {
            System.out.println("Pesquise pelo nome do Filme ou Digite Sair: ");
            busca = sc.nextLine();

            if (!busca.equalsIgnoreCase("Sair")) {
                //titulosBuscados.add(buscaFilme(busca));
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco + busca.replace(" ", "+") + "&apikey=86023a29"))
                        .GET() // Default method, optional
                        .header("Accept", "application/json")
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                Gson gson = new GsonBuilder()
                        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                        .setPrettyPrinting()
                        .create();

                TituloDTO tituloDTO = gson.fromJson(response.body(), TituloDTO.class);
                if (tituloDTO.Title() != null){
                    Titulo titulo = new Titulo(tituloDTO);
                    titulosBuscados.add(titulo);
                    System.out.println(titulo.toString());
                }else {
                    System.out.println("titulo nao encontrado.");
                }


            } else {
                FileWriter escrita = new FileWriter(arquivo);
                Gson gson = new GsonBuilder().create();
                escrita.write(gson.toJson(titulosBuscados));
                escrita.close();

                System.out.println("Gravando e Saindo... ");
            }
        }

    }
}

package br.com.alura.projeto.screenmatch.service;

import br.com.alura.projeto.screenmatch.dto.DadosFilme;
import br.com.alura.projeto.screenmatch.model.Filme;
import br.com.alura.projeto.screenmatch.model.Tradutor;
import br.com.alura.projeto.screenmatch.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class FilmeService {
    public final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String chave = "&apikey=86023a29";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();
    Scanner sc = new Scanner(System.in);
    private final FilmeRepository repository;



    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public void buscarFilme() {
        Tradutor tradutor = new Tradutor();

        System.out.println("\nDigite o nome do Filme: ");
        var buscaTitulo = sc.nextLine();

        var json = consumoAPI.obterDados(ENDERECO + buscaTitulo.replace(" ", "+") + chave);
        System.out.println(json);

        DadosFilme dados = converteDados.obterDadosDoJsonParaObjeto(json, DadosFilme.class);
        System.out.println(dados);
        String sinopse = tradutor.traduzir(dados.sinopse());
        Filme filme;


        if (sinopse != null) {
            filme = new Filme(dados, sinopse);
            System.out.println(filme);

        }else {
            filme = new Filme(dados);
            System.out.println(filme);
            System.out.println("Não foi possivel traduzir a sinopse. ");
        }
        repository.save(filme);

        System.out.println("\nRetornando ao Menu...");
    }
}


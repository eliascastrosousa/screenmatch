package br.com.alura.projeto.screenmatch.cli;

import br.com.alura.projeto.screenmatch.service.FilmeService;
import br.com.alura.projeto.screenmatch.service.SerieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PrincipalCLI implements CommandLineRunner {

    Scanner sc = new Scanner(System.in);
    private final FilmeCLI filmeCLI;
    private final SerieCLI serieCLI;

    public PrincipalCLI(FilmeService filmeService, FilmeCLI filmeCLI, SerieCLI serieCLI) {
        this.filmeCLI = filmeCLI;
        this.serieCLI = serieCLI;
    }


    @Override
    public void run(String... args) throws Exception {


        System.out.println("Entrou no principal antes do menu");

        var menu = """
            \n\n*** BEM VINDO AO SCREEN MATCH ***
            
            1 - BUSCAR FILMES
            2 - BUSCAR SERIES
            0 - SAIR
            
            DIGITE:
            """;

        var opcao = "";

        while (!opcao.equals("0")) {

            System.out.println(menu);

            opcao = sc.nextLine();

            switch (opcao) {

                case "0":
                    System.out.println("Saindo...");
                    break;

                case "1":
                    filmeCLI.initial();
                    break;

                case "2":
                    serieCLI.initial();
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }



}




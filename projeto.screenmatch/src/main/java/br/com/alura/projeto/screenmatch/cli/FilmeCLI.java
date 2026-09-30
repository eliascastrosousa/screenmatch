package br.com.alura.projeto.screenmatch.cli;

import br.com.alura.projeto.screenmatch.service.FilmeService;
import br.com.alura.projeto.screenmatch.service.SerieService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FilmeCLI {
    private final FilmeService filmeService;
    Scanner sc = new Scanner(System.in);

    public FilmeCLI(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    public void initial(){

        String menu = """
            \n****       ****         SCREEN MATCH FILMES        ****        ****
            
            1 - Buscar Filmes
           
            
            0 - Sair
            
            Digite:
            """;

        var opc = "";

        while (!opc.equals("0")) {

            System.out.println(menu);

            opc = sc.nextLine();

            switch (opc) {

                case "0":
                    System.out.println("Voltando ao menu principal...");
                    break;

                case "1":
                    System.out.println("\n**** Buscar Filmes ****");
                    filmeService.buscarFilme();
                    break;


                default:
                    System.out.println("\nResposta inválida!");
                    break;
            }
        }
    }
}

package br.com.alura.projeto.screenmatch.cli;

import br.com.alura.projeto.screenmatch.service.SerieService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SerieCLI {

    private final SerieService serieService;
    Scanner sc = new Scanner(System.in);

    public SerieCLI(SerieService serieService) {
        this.serieService = serieService;
    }

    public void initial(){

            String menu = """
            \n****       ****         SCREEN MATCH SERIES        ****        ****
            
            1 - Buscar Séries
            2 - Buscar Episódios
            3 - Listar Séries Buscadas
            
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
                        System.out.println("\n**** Busca Séries ****");
                        serieService.buscaSerie();
                        break;

                    case "2":
                        System.out.println("\n***** Busca Episódios *****\n");
                        serieService.buscaEpisodios();
                        break;

                    case "3":
                        System.out.println("\nListar Séries Buscadas\n-------------------------------------\n");
                        serieService.listarSeriesBuscadas();
                        break;

                    default:
                        System.out.println("\nResposta inválida!");
                        break;
                }
            }
        }
    }

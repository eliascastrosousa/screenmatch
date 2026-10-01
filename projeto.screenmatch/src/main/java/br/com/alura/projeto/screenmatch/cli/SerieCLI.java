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
            4 - Buscar serie por Titulo
            5 - Buscar Series por Ator
            6 - Buscar top 5 Series
            7 - Buscar Series top categoria
            8 - Busca Personalizada Avaliacao e Temporadas
            
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
                        System.out.println("\nBuscar Séries\n-------------------------------------\n");

                        serieService.buscaSerie();
                        break;

                    case "2":
                        System.out.println("\nBusca Episódios\n-------------------------------------\n");

                        serieService.buscaEpisodios();
                        break;

                    case "3":
                        System.out.println("\nListar Séries Buscadas\n-------------------------------------\n");
                        serieService.listarSeriesBuscadas();
                        break;

                    case "4":
                        System.out.println("\nBuscar Serie por titulo\n-------------------------------------\n");
                        serieService.buscarSeriePorTitulo();
                        break;
                    case "5":
                        System.out.println("\nBuscar Series por ator\n-------------------------------------\n");
                        serieService.buscarSeriesPorAtor();
                        break;
                    case "6":
                        System.out.println("\nBuscar Top 5 Series\n-------------------------------------\n");
                        serieService.buscarTop5Series();
                        break;
                    case "7":
                        System.out.println("\nBuscar Series top categoria\n-------------------------------------\n");
                        serieService.buscarSeriesPorCategoria();
                        break;
                    case "8":
                        System.out.println("\nBusca Personalizada Avaliacao e Temporadas\n-------------------------------------\n");
                        serieService.buscarSeriesPorAvaliacaoTemporadas();
                        break;



                    default:
                        System.out.println("\nResposta inválida!");
                        break;
                }
            }
        }
    }

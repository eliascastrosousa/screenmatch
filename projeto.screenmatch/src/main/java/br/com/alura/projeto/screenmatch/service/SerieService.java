package br.com.alura.projeto.screenmatch.service;

import br.com.alura.projeto.screenmatch.dto.DadosSerie;
import br.com.alura.projeto.screenmatch.dto.DadosTemporada;
import br.com.alura.projeto.screenmatch.model.*;
import br.com.alura.projeto.screenmatch.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
public class SerieService {
    public final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String chave = "&apikey=86023a29";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados converteDados = new ConverteDados();
    Scanner sc = new Scanner(System.in);
    List<DadosTemporada> temporadas = new ArrayList<>();
    List<Serie> listaSeries = new ArrayList<>();

    private final SerieRepository repository;

    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public void buscaSerie(){
        Tradutor tradutor = new Tradutor();

        System.out.println("\nDigite o nome da Serie: ");
        var buscaTitulo = sc.nextLine();

        try {
            var json = consumoAPI.obterDados(ENDERECO + buscaTitulo.replace(" ", "+") + chave);
            System.out.println(json);
            DadosSerie dados = converteDados.obterDadosDoJsonParaObjeto(json, DadosSerie.class);
            if (dados.tipo() == "serie") {
                String sinopse = tradutor.traduzir(dados.sinopse());

                if (sinopse == null) {
                    Serie serie = new Serie(dados);
                    System.out.println("Serie: " + serie);
                    System.out.println("Não foi possivel traduzir a sinopse. ");
                    //listaSeries.add(serie);
                    repository.save(serie);

                } else {
                    Serie serie = new Serie(dados, sinopse);
                    System.out.println("sinopse traduzida: " + sinopse);
                    //listaSeries.add(serie);
                    System.out.println(serie);
                    repository.save(serie);

                }
            }else {
                System.out.println("Tente novamnte com uma Serie.");
            }

            System.out.println("\nRetornando ao Menu...");
        } catch (RuntimeException e) {
            System.out.println("Não foi possivel salvar a serie: " + e.getMessage());
        }

    }

    public void listarSeriesBuscadas() {

//        listaSeries.stream().sorted(Comparator.comparing(Serie::getGenero)
//                        .reversed())
//                .forEach(System.out::println);

        listaSeries = repository.findAll();
        System.out.println("Series salvas: \n");
        listaSeries.forEach(s-> System.out.println(s.getTitulo()));

    }

    public void buscaEpisodios(){
        listarSeriesBuscadas();
        System.out.println("\nDigite o nome da Serie para trazer os episodios: ");
        var nomeSerie = sc.nextLine();

        Optional<Serie> serieBuscada =  listaSeries.stream().filter(s->s.getTitulo().toLowerCase().contains(nomeSerie.toLowerCase())).findFirst();

        if (serieBuscada.isPresent()) {

            Serie serie = serieBuscada.get();

            for (int i = 1; i <= serie.getTotalTemporadas(); i++) {
                    var json = consumoAPI.obterDados(ENDERECO + serie.getTitulo().replace(" ", "+") + "&season=" + i + chave);
                    temporadas = gravaTemporadas(json);
            }

            System.out.println("\n*** GUIA DE EPISÓDIOS ***");
            temporadas.forEach(t -> t.episodios().forEach(System.out::println));

            List<Episodio> episodios = temporadas.stream()
                    .flatMap(dtemp -> dtemp.episodios().stream()
                            .map(dep-> new Episodio(dtemp, dep)))
                    .collect(toList());

            serie.setEpisodios(episodios);
            serieBuscada.ifPresent(System.out::println);

            repository.save(serieBuscada.get());
            serieBuscada.ifPresent(System.out::println);


        }else {
            System.out.println("Serie nao encontrada.");
        }



    }

    public List<DadosTemporada>  gravaTemporadas(String json){
        DadosTemporada temporada = converteDados.obterDadosDoJsonParaObjeto(json, DadosTemporada.class);
        //System.out.println(json);
        //System.out.println(temporada);
        temporadas.add(temporada);
        return temporadas;
    }

    public void buscarSeriePorTitulo() {
        System.out.println("\nDigite o nome da Serie: ");
        var buscaTitulo = sc.nextLine();

        Optional<Serie> serieEncontrada =
         repository.findByTituloContainingIgnoreCase(buscaTitulo);

        if (serieEncontrada.isPresent()) {
            System.out.println("Dados da Série: ");
            Serie serie = serieEncontrada.get();
            System.out.println(serie);
        }else {
            System.out.println("Serie nao encontrada.");
        }
    }

    public void buscarSeriesPorAtor() {
        System.out.println("\nDigite o nome do Ator: ");
        var buscaTitulos = sc.nextLine();

        List<Serie> seriesEncontradas =
                repository.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(buscaTitulos, 8.5);

        if (seriesEncontradas.isEmpty()) {
            System.out.println("Series nao encontradas.");

        }else {
            System.out.println("Séries encontradas: ");
            seriesEncontradas.forEach(System.out::println);
        }

    }

    public void buscarTop5Series() {
        List<Serie> seriesEncontradas =
                repository.findTop5ByOrderByAvaliacaoDesc();

        if (seriesEncontradas.isEmpty()) {
            System.out.println("Series nao encontradas.");

        }else {
            System.out.println("Séries encontradas: ");
            seriesEncontradas.forEach(s-> System.out.println(s.getTitulo() + " Nota: " + s.getAvaliacao() ));
        }
    }

    public void buscarSeriesPorCategoria() {
        System.out.println("Deseja buscar serie por qual categoria? ");
        var nomeGenero = sc.nextLine();
        Categoria categoria = Categoria.fromPortugues(nomeGenero);
        if (categoria == null) {
            System.out.println("Não foi possivel encontrar as series na categoria informada.");
        }else {
            listaSeries = repository.findByGenero(categoria);
            System.out.println("Series da categoria: " + categoria);
            listaSeries.forEach(System.out::println);
        }
    }

    public void buscarSeriesPorAvaliacaoTemporadas() {
        System.out.println("Digite a avaliacao que deseja buscar: ");
        double avaliacao = sc.nextDouble();
        System.out.println("Qual numero de temporadas? ");
        int ntemporadas = sc.nextInt();

        listaSeries = repository.findByAvaliacaoGreaterThanEqualAndTotalTemporadas(avaliacao, ntemporadas);
        if (listaSeries.isEmpty()){
            System.out.println("Series nao encontradas.");
        }else {
            System.out.println("Series encontradas: ");
            listaSeries.forEach(System.out::println);
        }
    }
}















































//        var json = consumoAPI.obterDados(ENDERECO + buscaTitulo.replace(" ", "+") + chave);
//        System.out.println("json! " + json);
//
//        DadosSerie dados = converteDados.obterDadosDoJsonParaObjeto(json, DadosSerie.class);
//        System.out.println("dados: " +dados);
//
//        if (dados.tipo().equalsIgnoreCase("Series")) {
//            for (int i = 1; i <= dados.totalTemporadas(); i++) {
//                json = consumoAPI.obterDados(ENDERECO + buscaTitulo.replace(" ", "+") + "&season=" + i + chave);
//                gravaTemporadas(json);
//                System.out.println(json);
//            }
//
//            System.out.println("\n*** GUIA DE EPISÓDIOS ***");
//            //listaSeries = temporadas.forEach(t -> t.episodios().forEach(e -> e.)));
//
//            temporadas.forEach(t -> t.episodios().forEach(e -> System.out.printf("S%dE%d: %s \n", t.numero(), e.numero(), e.titulo())));
//
//            List<DadosTemporada> primeiraTemporada = new ArrayList<>();
//            primeiraTemporada.add(temporadas.get(0));
//            //primeiraTemporada.forEach(p -> p.episodios().forEach(e-> System.out.printf("primeira temporada: S%dE%d: %s \n",p.numero(), e.numero() ,e.titulo())));
//
//            System.out.println("\nTop 5 episodios: \n");
//            List<DadosEpisodio> dadosEpisodios = temporadas.stream()
//                    .flatMap(t -> t.episodios().stream())
//                    .collect(toList());
//
//            System.out.println("episodios!!");
//
//            dadosEpisodios.stream().filter(d -> !d.avaliacao().equalsIgnoreCase("N/A"))
//                    .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
//                    .limit(5)
//                    .forEach(System.out::println);
//
////                System.out.println("\nTop 5 episodios classe Episodio:\n");
//
//            List<Episodio> episodios = temporadas.stream()
//                    .flatMap(dt -> dt.episodios().stream().map(de -> new Episodio(dt, de)))
//                    .collect(Collectors.toList());
//
////                episodios.stream().filter(e -> !e.getAvaliacao().isNaN())
////                        .sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
////                        //.peek(e-> System.out.println("Ordenação " + e))
////                        .limit(5)
////                        .map(e -> e.getTitulo().toUpperCase())
////                        //.peek(e-> System.out.println("titulo em letra maiuscula " + e))
////                        .forEach(System.out::println);
//
//            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
////            System.out.println("\nDigite o ano que quer buscar os episodios: ");
////            var ano = sc.next();
////            try {
////
////                var dataBuscainicio = LocalDate.of(Integer.parseInt(ano), 1, 1);
////                var dataBuscafim = LocalDate.of(Integer.parseInt(ano), 12, 31);
////
////                List<Episodio> episodiosEncontrados = episodios.stream()
////                        .filter(e -> e.getDataLancamento() != null &&
////                                e.getDataLancamento().isAfter(dataBuscainicio) &&
////                                e.getDataLancamento().isBefore(dataBuscafim)).toList();
////
////                if (!episodiosEncontrados.isEmpty()){
////                    episodiosEncontrados.stream().forEach(e-> System.out.printf("\nEpisodio: %d, %d temporada. Titulo: %s Data Lançamento: %s",
////                            e.getNumeroEpisodio(), e.getTemporada(), e.getTitulo(),
////                            e.getDataLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
////                }else {
////                    System.out.println("Episodios nesta data não foram encontrados.");
////                }
////
////            } catch (NumberFormatException | NullPointerException e) {
////                System.out.println("Erro: " + e);
////            }
////
////            System.out.println("\n\nDigite o nome do episodio: ");
////            var busca = sc.next();
////            var episodioBuscado = episodios.stream()
////                    .filter(e -> e.getTitulo()
////                            .toLowerCase(Locale.ROOT)
////                            .contains(busca.toLowerCase(Locale.ROOT)))
////                    .findFirst();
////
////            if (episodioBuscado.isPresent()){
////                System.out.println("Episodio encontrado: ");
////                episodioBuscado.ifPresent(e-> System.out.printf("Titulo: %s S%dE%d Avaliação IMDB: %s Data de lancamento: %s", e.getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getAvaliacao(), e.getDataLancamento().format(formatador) ));
////            }else {
////                System.out.println("Episodio nao encontrado.");
////            }
//
//            Map<Integer, Double> avaliacaoTemporada = episodios.stream()
//                    .filter(e -> e.getAvaliacao() > 0.0)
//                    .collect(Collectors.groupingBy(Episodio::getTemporada, Collectors.averagingDouble(Episodio::getAvaliacao)));
//            System.out.println("\nNotas Gerais Avaliacao por Temporada: " + avaliacaoTemporada);
//
//            //system.out.println(" Primeiro episodio: " + episodios.getFirst().getTemporada());
//            //System.out.println("Episodio: " + episodios.stream().filter(episodio -> episodio.getTemporada().equals(1)).filter(episodio -> episodio.getNumeroEpisodio().equals(5)));
//
//            //episodios.forEach(System.out::println);
//
//            DoubleSummaryStatistics statistics = episodios.stream()
//                    .filter(e -> e.getAvaliacao() > 0.0)
//                    .collect(Collectors.summarizingDouble(Episodio::getAvaliacao));
//
//            System.out.println("Estatisticas da Serie: ");
//            System.out.printf("Melhor nota: %s, \nMedia das avaliações: %.2f \nMenor nota: %.2f"
//                    , statistics.getMax(), statistics.getAverage(), statistics.getMin());
//
//        }else {
//            System.out.println("Opção invalida.");
//        }
//
//        System.out.println("\nRetornando ao Menu...");
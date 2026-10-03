package br.com.alura.projeto.screenmatch.controller;

import br.com.alura.projeto.screenmatch.dto.SerieDTO;
import br.com.alura.projeto.screenmatch.repository.SerieRepository;
import br.com.alura.projeto.screenmatch.service.SerieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    public SerieController( SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping()
    public List<SerieDTO> listarSeriesBuscadas(){
        return serieService.listarSeriesBuscadas();
    }

    @GetMapping("/top5")
    public List<SerieDTO> listarTop5Series(){
        return serieService.buscarTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos(){
        return serieService.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterSerie(@PathVariable Long id){
        return serieService.buscarSerie(id);
    }


}

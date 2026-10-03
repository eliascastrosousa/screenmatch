package br.com.alura.projeto.screenmatch.repository;

import br.com.alura.projeto.screenmatch.dto.DadosTemporada;
import br.com.alura.projeto.screenmatch.model.Categoria;
import br.com.alura.projeto.screenmatch.model.Serie;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long>{

    Optional<Serie> findByTituloContainingIgnoreCase(String titulo);

    List<Serie> findByAtoresContainingIgnoreCase(String buscaTitulos);

    List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String buscaTitulos, double v);

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findByGenero(Categoria categoria);

    List<Serie> findByAvaliacaoGreaterThanEqualAndTotalTemporadas(double avaliacao, int ntemporadas);

    //@Query("select s from ")
    List<Serie> findTop5ByOrderByEpisodiosDataLancamentoDesc();

    @Query("SELECT s FROM Serie s " +
            "JOIN s.episodios e " +
            "GROUP BY s " +
            "ORDER BY MAX(e.dataLancamento) DESC LIMIT 5")
    List<Serie> encontrarEpisodiosMaisRecentes();

    @Query("SELECT s FROM Serie s " +
            "JOIN s.episodios e " +
            "GROUP BY s " +
            "ORDER BY MAX(e.dataLancamento) DESC LIMIT 5")
    List<Serie> lancamentosMaisRecentes();
}

package br.com.alura.projeto.screenmatch.repository;

import br.com.alura.projeto.screenmatch.model.Serie;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long>{
}

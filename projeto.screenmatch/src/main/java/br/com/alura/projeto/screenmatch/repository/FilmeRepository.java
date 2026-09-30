package br.com.alura.projeto.screenmatch.repository;

import br.com.alura.projeto.screenmatch.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}

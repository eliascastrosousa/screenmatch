package br.com.alura.projeto.screenmatch.model;

import br.com.alura.projeto.screenmatch.dto.DadosFilme;
import jakarta.persistence.*;

import java.util.OptionalDouble;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;

    private String duracao;

    @Enumerated(EnumType.STRING)
    private Categoria genero;

    private Double avaliacao;

    private String escritor;

    private String diretor;
    private String poster;
    private String sinopse;

    public Filme() {
    }

    public Filme(DadosFilme dadosFilme) {
        this.titulo = dadosFilme.titulo();
        this.avaliacao = OptionalDouble.of(dadosFilme.notaIMDB()).orElse(0);
        this.duracao = dadosFilme.duracao();
        this.genero = Categoria.fromString(dadosFilme.genero().split(",")[0].trim());
        this.escritor = dadosFilme.escritor();
        this.diretor = dadosFilme.diretor();
        this.poster = dadosFilme.poster();
        this.sinopse = dadosFilme.sinopse();
    }

    public Filme(DadosFilme dadosFilme, String sinopse) {
        this.titulo = dadosFilme.titulo();
        this.avaliacao = OptionalDouble.of(dadosFilme.notaIMDB()).orElse(0);
        this.duracao = dadosFilme.duracao();
        this.genero = Categoria.fromString(dadosFilme.genero().split(",")[0].trim());
        this.escritor = dadosFilme.escritor();
        this.diretor = dadosFilme.diretor();
        this.poster = dadosFilme.poster();
        this.sinopse = sinopse;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", duracao='" + duracao + '\'' +
                ", genero=" + genero +
                ", avaliacao=" + avaliacao +
                ", escritor='" + escritor + '\'' +
                ", diretor='" + diretor + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'' +
                '}';
    }
}

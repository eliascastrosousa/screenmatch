package com.eliascastro.screenmatch.exercicios.desafioGravacaoFilmes;

public class Titulo {
    private String titulo;
    private String ano;
    private String duracao;
    private String genero;
    private String diretor;

    public Titulo(TituloDTO tituloDTO) {

        this.titulo = tituloDTO.Title();
        this.ano = tituloDTO.Year().substring(0,4);
        int indiceFim = tituloDTO.Runtime().indexOf(" ");
        this.duracao = tituloDTO.Runtime();
        this.genero = tituloDTO.Genre();
        this.diretor = tituloDTO.Director();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAno() {
        return ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getDiretor() {
        return diretor;
    }

    @Override
    public String toString() {
        return "( Titulo:'" + titulo + '\'' +
                ", Ano: '" + ano + '\'' +
                ", Duracao='" + duracao + '\'' +
                ", Genero='" + genero + '\'' +
                ", Diretor='" + diretor + '\'' +
                '}'+")";
    }
}

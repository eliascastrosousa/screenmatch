package com.eliascastro.screenmatch.Filmes;

import com.eliascastro.screenmatch.Filmes.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "Filme: " + getNome() + " (" + getAnoDeLancamento() + ")";
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }
}

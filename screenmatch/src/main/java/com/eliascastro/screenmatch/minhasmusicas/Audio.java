package com.eliascastro.screenmatch.minhasmusicas;

public class Audio {

    protected String titulo;
    private int TotalCurtidas;
    private int totalReproducoes;
    private int classificacao;

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void curtiu(){
        this.TotalCurtidas++;
    }

    public void reproduziu(){
        this.totalReproducoes++;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCurtidas() {
        return TotalCurtidas;
    }

    public int getReproducoes() {
        return totalReproducoes;
    }


}

package com.eliascastro.screenmatch.exercicios.exercicio_desafio;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int ano;

    public Titulo(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.nome.compareTo(outroTitulo.nome);
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                ", ano=" + ano +
                '}';
    }
}

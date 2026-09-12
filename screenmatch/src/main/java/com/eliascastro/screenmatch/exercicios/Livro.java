package com.eliascastro.screenmatch.exercicios;

public class Livro implements Calculavel {
    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public void calcularPrecoFinal(String nome, int quantidade, double preco) {
        setNome(nome);
        setPreco(preco);
        System.out.println(getNome() + ", " + quantidade + " Quantidades. \nPreço final:  " + quantidade * getPreco());
    }
}

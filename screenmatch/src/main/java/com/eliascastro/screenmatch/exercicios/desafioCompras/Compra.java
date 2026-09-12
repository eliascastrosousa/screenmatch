package com.eliascastro.screenmatch.exercicios.desafioCompras;

import com.eliascastro.screenmatch.exercicios.exercicio_desafio.Titulo;

public class Compra implements Comparable<Compra> {
    private String descricao;
    private double valor;

    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return descricao + " no valor de: R$" + valor ;  }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.valueOf(this.getValor()).compareTo(Double.valueOf(outraCompra.getValor()));
    }

}

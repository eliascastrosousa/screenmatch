package com.eliascastro.screenmatch.exercicios;

public class Servico extends Item implements Tributavel{

    private int quantidadeHoras;

    public int getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(int quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }


    @Override
    public double calculaImposto() {
        return getPreco() * 0.12;
    }
}

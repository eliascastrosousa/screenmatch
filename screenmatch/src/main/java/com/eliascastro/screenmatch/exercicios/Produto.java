package com.eliascastro.screenmatch.exercicios;

public class Produto extends Item implements Tributavel{

    private double peso;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public double calculaImposto() {
        return getPreco() * 0.1;
    }


}

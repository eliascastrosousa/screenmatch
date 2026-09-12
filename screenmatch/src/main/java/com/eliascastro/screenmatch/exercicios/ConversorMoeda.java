package com.eliascastro.screenmatch.exercicios;

public class ConversorMoeda implements ConversaoFinanceira {
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public double converterDolarParaReal() {
        return getValor() * 5.30 ;
    }
}

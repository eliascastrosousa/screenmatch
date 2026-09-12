package com.eliascastro.screenmatch.exercicios;

public class CalculadoraImposto {
    private double totalImposto = 0;

    public void calculaImposto(Tributavel tributavel){
        totalImposto += tributavel.calculaImposto();
    }
}

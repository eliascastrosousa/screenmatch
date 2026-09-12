package com.eliascastro.screenmatch.exercicios;

public class ConversorMoeda_Main {
    public static void main(String[] args) {
        ConversorMoeda conversorDolar = new ConversorMoeda();

        conversorDolar.setValor(10.00);
        double valorConvertido = conversorDolar.converterDolarParaReal();

        System.out.println("Valor convertido em reais: " + valorConvertido);
    }
}

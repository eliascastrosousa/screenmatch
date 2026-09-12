package com.eliascastro.screenmatch.exercicios;

public class CalculadoraSalaRetangular implements CalculoGeometrico {


    @Override
    public void calcularArea(double altura, double largura) {
        double area = altura * largura;
        System.out.println("A Area é: " + area);
    }

    @Override
    public void calcularPerimetro(double altura, double largura) {
        double area = 2* altura + largura;
        System.out.println("O perimetro é: " + area);
    }
}

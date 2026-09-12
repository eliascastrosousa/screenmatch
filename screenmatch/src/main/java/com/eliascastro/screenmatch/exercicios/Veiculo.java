package com.eliascastro.screenmatch.exercicios;

public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;
    private double precoAno1;
    private double precoAno2;
    private double precoAno3;

    public void definirAno (double precoAno1, double precoAno2, double precoAno3){
        this.precoAno1 = precoAno1;
        this.precoAno2 = precoAno2;
        this.precoAno3 = precoAno3;
    }

    public void exibeVeiculo(){
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAno());
        System.out.println("Preço Ano 1: " + precoAno1);
        System.out.println("Preço Ano 2: " + precoAno2);
        System.out.println("Preço Ano 3: " + precoAno3);
        System.out.println("Menor Preço: " + calcularMenorPreco());
        System.out.println("Maior Preço: " + calcularMaiorPreco());
    }

    private double calcularMenorPreco() {
        double menorPreco = precoAno1;
        // 50
        if (menorPreco > precoAno2){
            // 50 > 40
            menorPreco = precoAno2;
            //40
        }if (menorPreco > precoAno3){
            // 40 > 55
            menorPreco = precoAno3;
        }
        return menorPreco;
        //40
    }

    private double calcularMaiorPreco() {
        double maiorPreco = precoAno1;
        // 50
        if (maiorPreco < precoAno2){
            // 50 < 60
            maiorPreco = precoAno2;
            //60
        }if (maiorPreco < precoAno3){
            // 60 < 55
            maiorPreco = precoAno3;
        }
        return maiorPreco;
        //40
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}

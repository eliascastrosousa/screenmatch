package com.eliascastro.screenmatch.exercicios;

public class Carro extends Veiculo{
    private String Cor;


    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        Cor = cor;
    }

    @Override
    public void exibeVeiculo() {
        System.out.println("\nCarro escolhido: ");
        super.exibeVeiculo();
        System.out.println("Cor: " + getCor());
    }
}

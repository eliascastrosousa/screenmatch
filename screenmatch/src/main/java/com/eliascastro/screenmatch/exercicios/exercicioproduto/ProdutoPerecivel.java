package com.eliascastro.screenmatch.exercicios.exercicioproduto;

public class ProdutoPerecivel extends Produto{

    String dataValidade;

    public ProdutoPerecivel(String nome, double preco, int quantidade, String dataValidade) {
        super(nome, preco, quantidade);
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {

        return super.toString() + " Data de validade: " + dataValidade ;
    }
}

package com.eliascastro.screenmatch.exercicios.exercicioproduto;

/*
* Crie uma classe Produto com atributos como nome, preco, e quantidade. ok
* Em seguida, crie uma lista de objetos Produto utilizando a classe ArrayList.
* Adicione alguns produtos, imprima o tamanho da lista e recupere um produto pelo índice.
* */

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto = " +
                "nome: " + nome + '\'' +
                ", preco: " + preco +
                ", quantidade: " + quantidade;
    }
}

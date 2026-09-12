package com.eliascastro.screenmatch.exercicios.exercicioproduto;

import java.util.ArrayList;

public class Produto_main {
    public static void main(String[] args) {

        ArrayList<Produto> produto = new ArrayList<>();

        produto.add( new Produto("trakinas", 2.99, 5));
        produto.add( new Produto("passa-tempo", 1.99, 3));
        produto.add( new Produto("plugados", 2.49, 7));
        produto.add( new Produto("toddy", 1.49, 5));

        System.out.println(produto.size());
        System.out.println(produto.get(0).toString());
        System.out.println(produto.toString());



        ProdutoPerecivel produtoPerecivel = new ProdutoPerecivel("italaquinho", 5.00, 2, "2023-12-31");
        System.out.println(produtoPerecivel);



    }
}

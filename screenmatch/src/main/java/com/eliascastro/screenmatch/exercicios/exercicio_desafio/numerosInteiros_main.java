package com.eliascastro.screenmatch.exercicios.exercicio_desafio;
/*
* Crie uma lista de números inteiros e utilize o método Collections.sort para ordená-la em ordem crescente.
* Em seguida, imprima a lista ordenada.
Crie uma classe Titulo com um atributo nome do tipo String.
* Implemente a interface Comparable na classe para que seja possível ordenar uma lista de objetos Titulo.
No Exercício 2, crie alguns objetos da classe Titulo e adicione-os a uma lista.
* Utilize o método Collections.sort para ordenar a lista e, em seguida, imprima os títulos ordenados.
Crie uma lista utilizando a interface List e instancie-a tanto como ArrayList quanto como LinkedList.
* Adicione elementos e imprima a lista, mostrando que é possível trocar facilmente a implementação.
Modifique o Exercício 4 para declarar a variável de lista como a interface List, demonstrando o uso de polimorfismo.
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class numerosInteiros_main {
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<Integer>();
        listaNumeros.add(7);
        listaNumeros.add(3);
        listaNumeros.add(5);
        listaNumeros.add(8);;

        Collections.sort(listaNumeros);
        System.out.println(listaNumeros);

        List<Titulo> lista = new ArrayList<Titulo>();
        lista.add(new Titulo("matrix", 2000));
        lista.add(new Titulo("avalanche", 2013));
        lista.add(new Titulo("cloverfield", 2009));

        Collections.sort(lista);
        System.out.println(lista);

        List<Titulo> lista02 = new LinkedList<>();
        lista02.add(new Titulo("matrix", 2000));
        lista02.add(new Titulo("avalanche", 2013));
        lista02.add(new Titulo("cloverfield", 2009));

        System.out.println(lista);

        List<String> listaArrayList = new ArrayList<>();
        listaArrayList.add("Elemento 1");
        listaArrayList.add("Elemento 2");

        List<String> listaLinkedList = new LinkedList<>();
        listaLinkedList.add("Elemento A");
        listaLinkedList.add("Elemento B");

        System.out.println("ArrayList: " + listaArrayList);
        System.out.println("LinkedList: " + listaLinkedList);

        List<String> listaPolimorfica;

        listaPolimorfica = new ArrayList<>();
        listaPolimorfica.add("Elemento 1");
        listaPolimorfica.add("Elemento 2");
        System.out.println("ArrayList: " + listaPolimorfica);

        listaPolimorfica = new LinkedList<>();
        listaPolimorfica.add("Elemento A");
        listaPolimorfica.add("Elemento B");
        System.out.println("LinkedList: " + listaPolimorfica);

    }
}

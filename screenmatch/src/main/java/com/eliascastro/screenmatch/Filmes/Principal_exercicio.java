package com.eliascastro.screenmatch.Filmes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Principal_exercicio {
    public static void main(String[] args) {
        var filme01 = new Filme("Saneamento basico", 2004);
        var filme02 = new Filme("Alto da compadecida", 1990);
        var filme03 = new Filme("Central do brasil", 1996);
        var serie01 = new Serie("Friends", 2000);
        filme01.avalia(10);
        filme02.avalia(8);
        filme03.avalia(5);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme01);
        lista.add(filme02);
        lista.add(filme03);
        lista.add(serie01);

        System.out.println(lista.toString());

        for (Titulo item : lista){
            System.out.println(item);
            if (item instanceof Filme filme && filme.getClassificacao() >2){
                System.out.println("Classificação: "+ filme.getClassificacao());
            }
        }


        ArrayList<String> busca = new ArrayList<>();
        busca.add("Paulo");
        busca.add("Antonio");
        busca.add("Elias");
        Collections.sort(busca);
        System.out.println(busca);

        System.out.println("Lista de titulos ordenados: ");

        Collections.sort(lista);
        System.out.println(lista);

    }
}

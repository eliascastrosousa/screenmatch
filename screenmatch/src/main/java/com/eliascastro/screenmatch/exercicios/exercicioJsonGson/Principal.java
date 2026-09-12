package com.eliascastro.screenmatch.exercicios.exercicioJsonGson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal {
    public static void main(String[] args) {
        var json = """
          {
            "Nome" : "João",
            "Idade" : 30,
            "email" : "joao@email.com"
          }
        """;

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);
        System.out.println(pessoa);
    }
}

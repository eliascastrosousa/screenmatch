package br.com.alura.projeto.screenmatch.service;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConverteDados implements IConverteDados{

    Gson gson = new GsonBuilder().create();

    @Override
    public <T> T obterDadosDoJsonParaObjeto(String json, Class<T> classe) {
        return gson.fromJson(json, classe);
    }


}

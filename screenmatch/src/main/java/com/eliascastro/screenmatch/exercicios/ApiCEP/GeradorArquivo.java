package com.eliascastro.screenmatch.exercicios.ApiCEP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {
    public void geradorArquivoJson (Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // criei um construtor de json
        FileWriter escrita = new FileWriter(endereco.cep() + ".json"); // aqui criei o arquivo
        escrita.write(gson.toJson(endereco)); // aqui populei o arquivo com os dados de endereco em formato json
        escrita.close();
    }
}

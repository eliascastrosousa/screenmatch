package br.com.alura.projeto.screenmatch.dto;

import com.google.gson.annotations.SerializedName;

public record DadosFilme(
        @SerializedName("Title")
        String titulo,
        @SerializedName("Runtime")
        String duracao,
        @SerializedName("Genre")
        String genero,
        @SerializedName("Director")
        String diretor,
        @SerializedName("Writer")
        String escritor,
        @SerializedName("Plot")
        String sinopse,
        @SerializedName("Poster")
        String poster,
        @SerializedName("imdbRating")
        double notaIMDB
    ) {
}

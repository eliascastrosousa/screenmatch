package br.com.alura.projeto.screenmatch.dto;

import com.google.gson.annotations.SerializedName;


public record DadosSerie(
        @SerializedName("Title")
        String titulo,
        @SerializedName("Year")
        String ano,
        @SerializedName("totalSeasons")
        Integer totalTemporadas,
        @SerializedName("imdbRating")
        String avaliacao,
        @SerializedName("Type")
        String tipo,
        @SerializedName("Genre")
        String genero,
        @SerializedName("Actors")
        String atores,
        @SerializedName("Poster")
        String poster,
        @SerializedName("Plot")
        String sinopse)


    {
            @Override
            public String toString() {
                    return "\nTitulo: " + titulo + " | Total de temporadas: " + totalTemporadas + " | Avaliacao: " + avaliacao;
            }
    }

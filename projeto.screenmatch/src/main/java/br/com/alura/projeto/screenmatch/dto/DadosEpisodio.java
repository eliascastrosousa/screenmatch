package br.com.alura.projeto.screenmatch.dto;

import com.google.gson.annotations.SerializedName;

public record DadosEpisodio(
        @SerializedName("Title")
        String titulo,
        @SerializedName("Episode")
        Integer numero,
        @SerializedName("imdbRating")
        String avaliacao,
        @SerializedName("Plot")
        String sinopse,
        @SerializedName("Released")
        String dataLancamento) {
        @Override
        public String toString() {
                return "Titulo: " + titulo +
                        " | Numero: " + numero +
                        " | Avaliacao: " + avaliacao +
                        " | Sinopse: " + sinopse +
                        " | Data de lançamento: " + dataLancamento;
        }
}

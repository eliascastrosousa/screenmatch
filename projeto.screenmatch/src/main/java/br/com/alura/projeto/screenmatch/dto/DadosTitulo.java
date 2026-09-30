package br.com.alura.projeto.screenmatch.dto;

import com.google.gson.annotations.SerializedName;

public record DadosTitulo(
        @SerializedName("Type")
        String tipo ) {
}

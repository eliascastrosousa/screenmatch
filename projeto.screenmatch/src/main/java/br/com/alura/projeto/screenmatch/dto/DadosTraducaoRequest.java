package br.com.alura.projeto.screenmatch.dto;

public record DadosTraducaoRequest(
        String q,
        String source,
        String target,
        String format
) {
}

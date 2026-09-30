package br.com.alura.projeto.screenmatch.model;

import br.com.alura.projeto.screenmatch.DadosTraducao;
import br.com.alura.projeto.screenmatch.dto.DadosTraducaoRequest;
import br.com.alura.projeto.screenmatch.service.ConsumoAPI;
import br.com.alura.projeto.screenmatch.service.ConverteDados;

import com.google.gson.Gson;

public class Tradutor {

    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConverteDados converteDados = new ConverteDados();
    private final Gson gson = new Gson();

    private final String ENDERECO =
            "https://libretranslate.com/translate";

    public String traduzir(String texto) {

            var dadosTraducao = new DadosTraducaoRequest(
                    texto,
                    "en",
                    "pt",
                    "text"
            );

            String json = gson.toJson(dadosTraducao);

//            System.out.println("\nJSON ENVIADO:");
//            System.out.println(json);

            String resposta = consumoAPI.enviarDados(
                    ENDERECO,
                    json
            );

//            System.out.println("\nRESPOSTA DA API:");
//            System.out.println(resposta);

            DadosTraducao dados = converteDados
                    .obterDadosDoJsonParaObjeto(
                            resposta,
                            DadosTraducao.class
                    );

            return dados.translatedText();

    }
}
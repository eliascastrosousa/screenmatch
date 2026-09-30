package br.com.alura.projeto.screenmatch.service;

public interface IConverteDados {

    <T> T obterDadosDoJsonParaObjeto(String json, Class<T> classe);

       /* <T> representa um parâmetro de tipo (Type) genérico,
       servindo como um espaço reservado para um tipo de dado que será definido
       posteriormente ao usar uma classe, interface ou método */
}

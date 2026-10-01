package br.com.alura.projeto.screenmatch.model;

public enum Categoria {
    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime"),
    CURTA("Short", "Curta");


    private String categoriaOmdb;
    private String categoriaPortugues;

    Categoria(String categoriaOMDB, String categoriaPortugues) {

        this.categoriaOmdb = categoriaOMDB;
        this.categoriaPortugues = categoriaPortugues;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

    public static Categoria fromPortugues(String text) {
       try {
           for (Categoria categoria : Categoria.values()) {
               if (categoria.categoriaPortugues.equalsIgnoreCase(text)) {
                   return categoria;
               }
           }
       } catch (Exception e) {
           System.out.println(STR."Erro: \{e.getMessage()}");
       }
       return null;
    }
}

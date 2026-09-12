package com.eliascastro.screenmatch.minhasmusicas;

public class Musica extends Audio{

    private String Album;
    private String Cantor;
    private String genero;

    public Musica(String titulo, String album, String cantor, String genero) {
        this.titulo = titulo;
        this.Album = album;
        this.Cantor = cantor;
        this.genero = genero;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public String getCantor() {
        return Cantor;
    }

    public void setCantor(String cantor) {
        Cantor = cantor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


}

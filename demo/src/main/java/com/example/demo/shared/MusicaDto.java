package com.example.demo.shared;

import com.example.demo.model.Musica;

public class MusicaDto {
    
    private String id;
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private String compositor;
    private Integer anoLancamento;

    public String getTitulo(){
        return titulo;
    }
    public String getArtista() {
        return artista;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public static MusicaDto parse(Musica musica){
        MusicaDto dto = new MusicaDto();
        dto.setAlbum(musica.getAlbum());
        dto.setAnoLancamento(musica.getAnoLancamento());
        dto.setArtista(musica.getArtista());
        dto.setCompositor(musica.getCompositor());
        dto.setGenero(musica.getGenero());
        dto.setId(musica.getId());
        dto.setTitulo(musica.getTitulo());
        return dto;
    }
}

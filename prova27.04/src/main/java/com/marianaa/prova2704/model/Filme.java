package com.marianaa.prova2704.model;

public class Filme {

    private int id;
    private Categoria categoria;
    private String nome;

    
    public Filme() {
    }
    public Filme(Categoria categoria, String nome) {
        this.categoria = categoria;
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

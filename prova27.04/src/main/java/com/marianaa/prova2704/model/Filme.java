package com.marianaa.prova2704.model;

public class Filme {

    private int id;
    private int CategoriaID;
    private String nome;

    public Filme() {
    }
    public Filme(int categoriaID, String nome) {
        CategoriaID = categoriaID;
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCategoriaID() {
        return CategoriaID;
    }
    public void setCategoriaID(int categoriaID) {
        CategoriaID = categoriaID;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    
}

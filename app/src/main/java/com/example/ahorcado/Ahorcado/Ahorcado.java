package com.example.ahorcado.Ahorcado;

public class Ahorcado {
    private String palabra;
    private String categoria;

    public Ahorcado(String palabra, String categoria) {
        this.palabra = palabra;
        this.categoria = categoria;
    }

    public String getPalabra() {
        return palabra;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

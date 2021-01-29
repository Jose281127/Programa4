package com.example.ahorcado.Ahorcado;

public class Letra {
    private String letra;
    private Integer id;

    public Letra(String letra, Integer id) {
        this.letra = letra;
        this.id = id;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLetra() {
        return letra;
    }

    public Integer getId() {
        return id;
    }
}

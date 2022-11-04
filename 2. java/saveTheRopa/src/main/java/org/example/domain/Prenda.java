package org.example.domain;

import lombok.Data;

public @Data class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString(){
        return "Marca: " + this.marca + ". Modelo: " + this.modelo + ".";
    }
}

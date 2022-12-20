package com.example.segurosautos.entity.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatenteModeloMarca {
    private String patente;
    private String marca;
    private String modelo;
    private Double perdida;

    public PatenteModeloMarca(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }

    public PatenteModeloMarca(String patente, String modelo, String marca) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
    }

    public PatenteModeloMarca(String patente, String marca, String modelo, Double perdida) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.perdida = perdida;
    }
}

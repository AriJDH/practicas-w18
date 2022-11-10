package com.example.covid.domain;

import com.example.covid.domain.dtos.SintomaDTO;
import lombok.Data;

public @Data class Sintoma {
    private long codigo;
    private String nombre;
    private NivelDeGravedad nivelDeGravedad;

    public Sintoma(long codigo, String nombre, NivelDeGravedad nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public SintomaDTO toDTO(){
        return new SintomaDTO(nombre, nivelDeGravedad);
    }
}

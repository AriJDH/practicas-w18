package com.example.covid.domain.dtos;

import com.example.covid.domain.NivelDeGravedad;
import lombok.Data;

public @Data class SintomaDTO {
    private String nombre;
    private NivelDeGravedad nivelDeGravedad;

    public SintomaDTO(String nombre, NivelDeGravedad nivelDeGravedad) {
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}

package com.example.deportistas.DTOs;

import com.example.deportistas.domain.Deporte;
import com.example.deportistas.domain.NivelDeporte;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class DeporteDTO {
    private String nombre;
    private NivelDeporte nivelDeporte;

    public DeporteDTO(Deporte deporte){
        this.nombre = deporte.getNombre();
        this.nivelDeporte = deporte.getNivelDeporte();
    }

}

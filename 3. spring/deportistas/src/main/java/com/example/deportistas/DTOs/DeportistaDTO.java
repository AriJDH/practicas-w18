package com.example.deportistas.DTOs;

import com.example.deportistas.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public DeportistaDTO(Persona persona){
        this.nombre=persona.getNombre();
        this.apellido=persona.getApellido();
        this.nombreDeporte=persona.getDeporte()!=null?persona.getDeporte().getNombre():"No hace deportes";
    }
}

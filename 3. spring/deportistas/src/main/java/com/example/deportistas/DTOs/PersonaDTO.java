package com.example.deportistas.DTOs;

import com.example.deportistas.domain.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private DeporteDTO deporte;

    public PersonaDTO(Persona persona){
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.edad = persona.getEdad();
        this.deporte = new DeporteDTO(persona.getDeporte());
    }
}

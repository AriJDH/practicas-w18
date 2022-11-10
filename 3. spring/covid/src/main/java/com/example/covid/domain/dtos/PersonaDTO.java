package com.example.covid.domain.dtos;

import lombok.Data;

public @Data class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;

    public PersonaDTO(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}

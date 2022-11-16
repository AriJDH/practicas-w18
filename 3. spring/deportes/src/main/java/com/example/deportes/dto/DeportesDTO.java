package com.example.deportes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeportesDTO {

    private String nombre;
    private String nivel;

    public DeportesDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}

package com.ejerciciospring.ejercicios_spring.practica2_dto_response.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDeportistaDTO {

    private String nombre;

    private String apellido;

    private String nivel;

}

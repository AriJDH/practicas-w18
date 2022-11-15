package com.ejerciciospring.ejercicios_spring.practica2_dto_response.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {

    private String nombre;

    private String apellido;

    private Integer edad;

    private Deporte deporte;
}

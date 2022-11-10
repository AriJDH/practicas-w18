package com.ejerciciospring.ejercicios_spring.practica2_dto_response.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonaInDTO {

    private String nombre;

    private String apellido;

    private Integer edad;

    private String nombreDeporte;
}

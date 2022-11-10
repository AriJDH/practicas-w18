package com.ejerciciospring.ejercicios_spring.practica2_dto_response.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeporteDTO {

    private String nombre;

    private String nivel;

    private String message;
}

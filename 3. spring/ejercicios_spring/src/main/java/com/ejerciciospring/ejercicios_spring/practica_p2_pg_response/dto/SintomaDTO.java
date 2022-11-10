package com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SintomaDTO {

    private String codigo;

    private String nombre;

    private Integer nivel_de_gravedad;
}

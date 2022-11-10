package com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Persona {

    private Long id;

    private String nombre;

    private String apellido;

    private Integer edad;

    private List<Sintoma> sintomas;
}

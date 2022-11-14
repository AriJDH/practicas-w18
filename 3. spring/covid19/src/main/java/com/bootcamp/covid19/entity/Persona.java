package com.bootcamp.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomasPersona;

}

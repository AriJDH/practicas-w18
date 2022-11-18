package com.mercadolibre.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
}

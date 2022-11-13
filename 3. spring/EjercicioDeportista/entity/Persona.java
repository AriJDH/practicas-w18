package com.mercadolibre.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Deporte> deportes;
}

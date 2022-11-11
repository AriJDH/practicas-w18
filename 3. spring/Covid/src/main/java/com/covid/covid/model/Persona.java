package com.covid.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
    Integer id;
    String nombre;
    String apellido;
    Integer edad;
}

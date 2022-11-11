package com.covid.covid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sintoma {
    String codigo;
    String nombre;
    Integer nivelGravedad;
}

package com.darke.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sintoma {
    private Integer codigo;
    private String nombre;
    private String nivel_de_gravedad;
}

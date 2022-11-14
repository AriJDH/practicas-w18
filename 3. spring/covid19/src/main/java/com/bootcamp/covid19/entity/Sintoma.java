package com.bootcamp.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
}

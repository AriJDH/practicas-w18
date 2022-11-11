package com.example.covid.Entity;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;
}

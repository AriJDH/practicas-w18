package com.example.covid19.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Sintoma {

    private String codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public Sintoma(String codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}

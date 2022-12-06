package com.dh.joyeria.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class JoyaDtoRes {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}

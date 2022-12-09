package com.example.joyerialasperlas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class JewelDto {

    private String nombre;
    private String material;
    private double precio;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;


}

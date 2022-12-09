package com.example.joyerialasperlas.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateJewelRequestDto {

    private String nombre;
    private String material;
    private double precio;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

}

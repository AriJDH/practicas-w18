package com.example.joyeria_lasperlas.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JewelDTORequest {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}

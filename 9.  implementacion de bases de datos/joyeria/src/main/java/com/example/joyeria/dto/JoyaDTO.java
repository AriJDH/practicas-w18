package com.example.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JoyaDTO {

    private String nro_identificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean posee_pieda;

    private Boolean ventaONo;
}

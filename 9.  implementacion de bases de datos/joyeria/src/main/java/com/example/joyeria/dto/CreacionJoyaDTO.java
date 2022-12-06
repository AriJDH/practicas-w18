package com.example.joyeria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreacionJoyaDTO {

    private String nro_identificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean posee_pieda;

    private Boolean ventaONo;
}

package com.lasperlas.lasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDTO {
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
}

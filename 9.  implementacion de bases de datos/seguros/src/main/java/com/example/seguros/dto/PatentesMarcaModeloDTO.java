package com.example.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatentesMarcaModeloDTO {
    private String patente;
    private String marca;
    private String modelo;
}

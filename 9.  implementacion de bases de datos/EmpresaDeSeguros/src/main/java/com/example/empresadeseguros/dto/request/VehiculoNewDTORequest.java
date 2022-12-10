package com.example.empresadeseguros.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoNewDTORequest {
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private Integer cantRuedas;
}

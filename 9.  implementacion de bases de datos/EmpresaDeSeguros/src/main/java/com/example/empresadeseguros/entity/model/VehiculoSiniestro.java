package com.example.empresadeseguros.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestro {
    private String patente;
    private String marca;
    private String modelo;
    private Double perdidaEconomica;
}

package com.example.hqlvehiculos.DTO;

import lombok.Data;

import java.util.Set;
@Data
public class VehiculoDto {
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantRuedas;
}

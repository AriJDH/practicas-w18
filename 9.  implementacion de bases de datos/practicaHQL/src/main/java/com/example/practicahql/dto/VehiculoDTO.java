package com.example.practicahql.dto;

import com.example.practicahql.model.Siniestro;
import lombok.Data;

import java.util.Set;

@Data
public class VehiculoDTO {
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;
    private Set<SiniestroDTO> siniestros;
}

package com.bootcamp.PracticaHQL.dto.req;

import com.bootcamp.PracticaHQL.entity.Sinister;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
public class VehicleDto {
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;
    private Set<SiniesterDto> siniesters;
}

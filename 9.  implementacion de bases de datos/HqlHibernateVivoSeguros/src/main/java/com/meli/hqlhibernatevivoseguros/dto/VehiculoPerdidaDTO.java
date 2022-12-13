package com.meli.hqlhibernatevivoseguros.dto;

import com.meli.hqlhibernatevivoseguros.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class VehiculoPerdidaDTO {
    private Vehiculo vehiculo;
    private Double perdidaEconomica;
}
package com.hql.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTOReq {
    private String patente;
    private String marca;
    private String modelo;
    private int añoFabricacion;
    private int cantRuedas;
}

package com.example.hql2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehiculoSiniestro {

    private String patente;

    private String marca;

    private String modelo;

    private Double perdido;

}

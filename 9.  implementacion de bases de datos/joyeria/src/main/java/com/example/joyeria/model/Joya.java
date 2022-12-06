package com.example.joyeria.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String nro_identificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean posee_pieda;

    private Boolean ventaONo;
}

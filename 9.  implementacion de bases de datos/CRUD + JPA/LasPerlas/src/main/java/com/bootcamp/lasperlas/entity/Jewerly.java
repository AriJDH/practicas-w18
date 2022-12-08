package com.bootcamp.lasperlas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Jewerly")
public class Jewerly {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;

}

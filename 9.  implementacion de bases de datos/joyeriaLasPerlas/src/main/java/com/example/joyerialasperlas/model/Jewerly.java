package com.example.joyerialasperlas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="jewerly")
public class Jewerly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Long peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}

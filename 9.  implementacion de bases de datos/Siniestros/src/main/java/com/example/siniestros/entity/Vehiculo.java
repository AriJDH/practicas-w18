package com.example.siniestros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String patente;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private Integer anioFabricacion;
    @Column
    private Integer cantidadRuedas;
}

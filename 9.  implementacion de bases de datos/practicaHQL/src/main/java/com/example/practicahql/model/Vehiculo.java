package com.example.practicahql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Set<Siniestro> siniestros;
}

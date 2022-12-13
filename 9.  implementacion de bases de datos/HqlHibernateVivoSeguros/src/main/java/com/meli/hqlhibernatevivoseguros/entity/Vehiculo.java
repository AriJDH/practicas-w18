package com.meli.hqlhibernatevivoseguros.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private String matricula;
    private int anioFabricacion;
    private int cantidadRuedas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vehiculo_denunciado")
    private List<Siniestro>  siniestroList;
}

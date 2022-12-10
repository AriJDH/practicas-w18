package com.example.empresadeseguros.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private Integer cantRuedas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="vehiculo_id")
    private Set<Siniestro> siniestros;

}

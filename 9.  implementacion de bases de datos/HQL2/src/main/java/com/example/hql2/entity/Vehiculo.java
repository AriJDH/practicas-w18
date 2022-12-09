package com.example.hql2.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String patente;

    private String marca;

    private String modelo;

    private Integer anioDeFabricacion;

    private Integer cantRuedas;

    @OneToMany(mappedBy = "vehiculo")
    private Set<Siniestro> siniestroList;

}

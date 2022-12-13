package com.mercadolibre.seguros.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vehiculos")
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer ruedas;
    @OneToMany(mappedBy = "vehiculoDenunciado")
    private List<Siniestro> siniestros;

}

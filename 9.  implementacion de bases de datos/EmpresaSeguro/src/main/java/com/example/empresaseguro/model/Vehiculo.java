package com.example.empresaseguro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private Integer cantidadRuedas;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo")

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVehiculo")
    private List<Siniestro> list;
}

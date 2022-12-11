package com.example.hqlvehiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String patente;
    private String marca;
    private int modelo;
    private int anioFabricacion;
    private int cantRuedas;

   /* @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Set<Siniestro> siniestros;*/
}

package com.bootcamp.PracticaHQL.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Set<Sinister> siniesters;
}

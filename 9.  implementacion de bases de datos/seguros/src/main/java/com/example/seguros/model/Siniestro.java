package com.example.seguros.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate fechaSiniestro;
    private double perdidaEconomica;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Vehiculo vehiculoSiniestro;
}

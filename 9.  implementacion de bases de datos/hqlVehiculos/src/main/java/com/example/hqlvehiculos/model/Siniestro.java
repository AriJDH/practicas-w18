package com.example.hqlvehiculos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Vehiculo vehiculoDenunciado;
}

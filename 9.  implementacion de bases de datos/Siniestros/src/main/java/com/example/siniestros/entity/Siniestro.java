package com.example.siniestros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalDate fecha;
    @Column
    private Double perdidaEconomica;
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Vehiculo vehiculoDenunciado;
}

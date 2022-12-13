package com.mercadolibre.seguros.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "siniestros")
@Data
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private Double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name="vehiculo_id", nullable = false)
    private Vehiculo vehiculoDenunciado;
}

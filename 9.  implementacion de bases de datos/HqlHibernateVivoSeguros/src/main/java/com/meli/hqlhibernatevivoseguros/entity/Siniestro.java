package com.meli.hqlhibernatevivoseguros.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Siniestro")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
}

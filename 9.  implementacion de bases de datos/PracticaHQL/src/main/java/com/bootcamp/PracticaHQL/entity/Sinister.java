package com.bootcamp.PracticaHQL.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Entity
public class Sinister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
}

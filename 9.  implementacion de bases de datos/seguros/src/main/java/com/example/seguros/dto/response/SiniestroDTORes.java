package com.example.seguros.dto.response;

import com.example.seguros.model.Vehiculo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTORes {
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    private VehiculoDTORes vehiculoDenunciado;
}

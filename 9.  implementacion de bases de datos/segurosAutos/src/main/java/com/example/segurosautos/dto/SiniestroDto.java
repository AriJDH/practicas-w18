package com.example.segurosautos.dto;

import com.example.segurosautos.entity.Vehiculo;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDto {

    private Long id;
    private String fechaSiniestro;
    private Double perdidaEconomica;
    private Long vehiculoId;
}

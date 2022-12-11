package com.example.hqlvehiculos.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class SiniestroDto {
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    private Long idVehiculoDenunciado;
}

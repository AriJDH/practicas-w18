package com.example.practicahql.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SiniestroDTO {
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
}

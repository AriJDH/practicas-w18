package com.bootcamp.PracticaHQL.dto.req;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
public class SiniesterDto {
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
}

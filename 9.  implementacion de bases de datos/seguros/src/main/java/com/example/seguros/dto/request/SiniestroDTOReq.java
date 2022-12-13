package com.example.seguros.dto.request;

import com.example.seguros.dto.response.VehiculoDTORes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTOReq {
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    private VehiculoDTORes vehiculoDenunciado;
}
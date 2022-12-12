package com.example.clavecompuesta.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
public class CompraDTO {
    private Integer clienteid;
    private LocalDate fecha;
    private String product;
    private Double subTotal;
    private Double impuestos;
    private String direccionEnvio;
}

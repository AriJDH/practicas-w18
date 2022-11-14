package com.example.concesionarioautos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AutoSoloResponseDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Double numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;
}
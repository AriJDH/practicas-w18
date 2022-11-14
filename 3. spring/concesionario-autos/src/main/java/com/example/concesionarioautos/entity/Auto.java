package com.example.concesionarioautos.entity;

import lombok.*;


import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Auto {
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Double numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;
}

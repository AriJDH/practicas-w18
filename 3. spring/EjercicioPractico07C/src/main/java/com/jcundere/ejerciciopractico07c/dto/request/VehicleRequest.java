package com.jcundere.ejerciciopractico07c.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequest {

    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<ServiceRequest> services;
    private Integer countOfOwners;

}

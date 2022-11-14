package com.example.concesionaria.dto;

import com.example.concesionaria.entity.ServiceManteinance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<ServiceManteinance> serviceManteinances;
    private String countOfOwners;
}

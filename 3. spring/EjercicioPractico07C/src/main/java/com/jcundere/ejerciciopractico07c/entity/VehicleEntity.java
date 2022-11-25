package com.jcundere.ejerciciopractico07c.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntity {

    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<ServiceEntity> services;
    private Integer countOfOwners;


    public VehicleEntity(String brand, String model, LocalDate manufacturingDate, Long numberOfKilometers, Integer doors,
                         Integer price, String currency, List<ServiceEntity> services, Integer countOfOwners) {

        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

}

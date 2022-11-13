package com.bootcamp.CarAgency.entity;

import lombok.Data;
import java.util.List;

@Data
public class Vehicle {
    private Integer id=0;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public Vehicle() {
        this.id += 1;
    }
}

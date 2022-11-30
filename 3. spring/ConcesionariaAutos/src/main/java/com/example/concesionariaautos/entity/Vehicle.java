package com.example.concesionariaautos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    int id;
    String brand;
    String model;
    String manufacturingDate;
    int numberOfKilometers;
    int doors;
    double price;
    String currency;
    List<Service> services;
    int countOfOwners;

}

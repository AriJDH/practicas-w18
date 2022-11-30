package com.example.concesionariaautos.dto.request;

import com.example.concesionariaautos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VehicleRequestDto {

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

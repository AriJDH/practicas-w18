package com.example.concesionariaautos.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseVehicleNoServicesDto {

    String brand;
    String model;
    String manufacturingDate;
    int numberOfKilometers;
    int doors;
    double price;
    String currency;
    int countOfOwners;

}

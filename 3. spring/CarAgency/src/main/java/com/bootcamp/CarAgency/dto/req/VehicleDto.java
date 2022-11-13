package com.bootcamp.CarAgency.dto.req;

import com.bootcamp.CarAgency.entity.Service;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class VehicleDto {

    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;
}

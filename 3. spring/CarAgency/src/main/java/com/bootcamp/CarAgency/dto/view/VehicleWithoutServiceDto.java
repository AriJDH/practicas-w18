package com.bootcamp.CarAgency.dto.view;

import com.bootcamp.CarAgency.entity.Service;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VehicleWithoutServiceDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;
}

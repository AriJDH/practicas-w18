package com.mercadolibre.concesionariaautos.dto.AutoResponseDto;

import com.mercadolibre.concesionariaautos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AutoResponseDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private ArrayList<Service> services;
    private String countOfOwners;
}

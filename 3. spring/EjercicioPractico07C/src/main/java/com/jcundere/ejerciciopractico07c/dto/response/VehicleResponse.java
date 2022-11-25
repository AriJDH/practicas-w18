package com.jcundere.ejerciciopractico07c.dto.response;

import com.jcundere.ejerciciopractico07c.entity.ServiceEntity;
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
public class VehicleResponse {

    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Long numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<ServiceResponse> services;
    private Integer countOfOwners;

}

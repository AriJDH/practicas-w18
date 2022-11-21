package com.playground.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    private Integer id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;
}

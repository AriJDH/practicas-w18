package com.dh.relacionesjpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDtoReq {

    private String plate_number;
    private String brand;
    private String model;
    private Integer year_of_manufacture;
    private Integer wheels;


}

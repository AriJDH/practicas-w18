package com.example.consecionaria.dto.req;

import com.example.consecionaria.entity.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter

public class VehicleDTOReq {
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

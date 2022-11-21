package com.playground.app.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class VehicleDTOResp {

    private Integer id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private Integer countOfOwners;

}

package com.example.vehicle.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VehicleResponseDTO {
    private Integer id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;

}

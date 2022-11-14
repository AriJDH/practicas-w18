package spring.autos.v1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import spring.autos.v1.dto.CarDtoReq;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}

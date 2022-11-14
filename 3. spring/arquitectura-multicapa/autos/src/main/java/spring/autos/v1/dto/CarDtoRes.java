package spring.autos.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import spring.autos.v1.entity.Car;
import spring.autos.v1.entity.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CarDtoRes {
    private String brand;
    private String model;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private int price;
    private String currency;
    private int countOfOwners;

    public CarDtoRes(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.manufacturingDate = car.getManufacturingDate();
        this.numberOfKilometers = car.getNumberOfKilometers();
        this.doors = car.getDoors();
        this.price = car.getPrice();
        this.currency = car.getCurrency();
        this.countOfOwners = car.getCountOfOwners();
    }
}

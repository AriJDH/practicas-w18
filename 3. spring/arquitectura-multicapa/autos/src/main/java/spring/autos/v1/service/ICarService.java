package spring.autos.v1.service;

import spring.autos.v1.dto.CarDetailsDto;
import spring.autos.v1.dto.CarDtoReq;
import spring.autos.v1.dto.CarDtoRes;
import spring.autos.v1.entity.Car;

import java.util.Date;
import java.util.List;

public interface ICarService {
    CarDetailsDto addCar(CarDtoReq car);
    List<CarDtoRes> getAllCars();
    List<CarDtoRes> getCarsBetweenDates(Date since, Date to);
    List<CarDtoRes> getCarsBetweenPrices(int since, int to);
    CarDetailsDto getCarById(Long id);
}

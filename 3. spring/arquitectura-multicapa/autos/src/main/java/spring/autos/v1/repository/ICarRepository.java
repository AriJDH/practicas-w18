package spring.autos.v1.repository;

import spring.autos.v1.entity.Car;

import java.util.Date;
import java.util.List;

public interface ICarRepository {
    Long addCar(Car car);
    List<Car> getAllCars();
    List<Car> getCarsBetweenDates(Date since, Date to);
    List<Car> getCarsBetweenPrices(int since, int to);
    Car getCarById(Long id);
}

package spring.autos.v1.repository;

import org.springframework.stereotype.Repository;
import spring.autos.v1.entity.Car;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CarRepository implements ICarRepository {
    private Map<Long, Car> cars = new HashMap();
    private Long id;

    public CarRepository() {
        id = 1L;
    }

    @Override
    public Long addCar(Car car) {
        cars.put(id, car);
        id++;
        return id - 1;
    }

    @Override
    public List<Car> getAllCars() {
        return cars.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsBetweenDates(Date since, Date to) {
        return cars.entrySet().stream()
                .map(x -> x.getValue())
                .filter(c -> c.getManufacturingDate().after(since) && c.getManufacturingDate().before(to))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsBetweenPrices(int since, int to) {
        return cars.entrySet().stream()
                .map(x -> x.getValue())
                .filter(c -> since <= c.getPrice() && c.getPrice() <= to)
                .collect(Collectors.toList());
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> optionalCar = cars.entrySet().stream()
                .filter(x -> x.getKey() == id)
                .map(x -> x.getValue())
                .findFirst();

        return optionalCar.isPresent() ? optionalCar.get() : null;
    }
}

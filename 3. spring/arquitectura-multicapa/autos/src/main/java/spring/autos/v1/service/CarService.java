package spring.autos.v1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import spring.autos.v1.dto.CarDetailsDto;
import spring.autos.v1.dto.CarDtoReq;
import spring.autos.v1.dto.CarDtoRes;
import spring.autos.v1.entity.Car;
import spring.autos.v1.exceptions.NotFoundException;
import spring.autos.v1.repository.CarRepository;
import spring.autos.v1.repository.ICarRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {
    ICarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarDetailsDto addCar(CarDtoReq carDtoReq) {
        ObjectMapper op = new ObjectMapper();
        Car car = op.convertValue(carDtoReq, Car.class);
        Long id = carRepository.addCar(car);
        return new CarDetailsDto(id, car);
    }

    @Override
    public List<CarDtoRes> getAllCars() {
        return carsToCarsDto(carRepository.getAllCars());
    }

    @Override
    public List<CarDtoRes> getCarsBetweenDates(Date since, Date to) {
        return carsToCarsDto(carRepository.getCarsBetweenDates(since, to));
    }

    @Override
    public List<CarDtoRes> getCarsBetweenPrices(int since, int to) {
        return carsToCarsDto(carRepository.getCarsBetweenPrices(since, to));
    }

    @Override
    public CarDetailsDto getCarById(Long id) {
        Car car = carRepository.getCarById(id);
        if(car == null) throw new NotFoundException("Auto no encontrado");

        return new CarDetailsDto(id, car);
    }

    private List<CarDtoRes> carsToCarsDto(List<Car> cars) {
        return cars.stream()
                .map(CarDtoRes::new)
                .collect(Collectors.toList());
    }
}

package spring.autos.v1.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.autos.v1.dto.CarDetailsDto;
import spring.autos.v1.dto.CarDtoReq;
import spring.autos.v1.dto.CarDtoRes;
import spring.autos.v1.exceptions.NotFoundException;
import spring.autos.v1.service.CarService;
import spring.autos.v1.service.ICarService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class CarController {
    ICarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarDetailsDto> addCar(@RequestBody CarDtoReq carDtoReq) {
        return new ResponseEntity<>(carService.addCar(carDtoReq), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarDtoRes>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<CarDtoRes>> getCarsBetweenDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {
        return new ResponseEntity<>(carService.getCarsBetweenDates(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarDtoRes>> getCarsBetweenPrices(@RequestParam int since, @RequestParam int to) {
        return new ResponseEntity<>(carService.getCarsBetweenPrices(since, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDetailsDto> getCarById(@PathVariable Long id) {
        CarDetailsDto carDetailsDto = carService.getCarById(id);
        if(carDetailsDto == null) throw new NotFoundException("Auto no encontrado");
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }
}

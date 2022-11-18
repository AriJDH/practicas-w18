package com.example.vehicle.repository;

import com.example.vehicle.entity.Vehicle;
import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle findById(Integer id);

    void addVehicle(Vehicle vehicle);

    List<Vehicle> findByPrices(Double since, Double to);

    void deleteVehicleById(Integer id);

    void updateVehicle(Integer id, Vehicle vehicle);

    List<Vehicle> findByDates(LocalDate since, LocalDate to);
}

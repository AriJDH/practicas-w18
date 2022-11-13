package com.bootcamp.CarAgency.repository;

import com.bootcamp.CarAgency.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    void saveVehicle(Vehicle vehicle);
    List<Vehicle> findAll();
    List<Vehicle> findByManufacturingDate(String manufacturingDate);
    List<Vehicle> findByPrice(String price);
    Vehicle findById(Integer id);
}

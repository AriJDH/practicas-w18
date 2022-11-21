package com.playground.app.repository;

import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.playground.app.entity.Vehicle;

import java.util.Date;
import java.util.List;

public interface IVehicleRepository {

    // por defecto son todas publicas y absrtractas
    List<Vehicle> getAll();
    void createVehicle( Vehicle vehicle);
    Vehicle getById(Integer id);
    List<Vehicle> getByDates(Date since, Date to);
    List<Vehicle> getByPrice(Integer since, Integer to);
    void deleteById(Integer id);
    void update(Vehicle vehicle);


}

package com.example.concesionaria.repository;

import com.example.concesionaria.entity.ServiceManteinance;
import com.example.concesionaria.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {

    List<Vehicle> getVehicles();

    Vehicle getVehicleById(int id);
    void addVehicle(Vehicle vehicle);

    void addServiceToVehicle(ServiceManteinance serviceManteinance, int id);

}

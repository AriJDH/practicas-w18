package com.example.concesionaria.repository;

import com.example.concesionaria.entity.ServiceManteinance;
import com.example.concesionaria.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepository implements IVehicleRepository{

    private final Map<Integer, Vehicle> vehicles = new HashMap<Integer, Vehicle>();
    private int counter = 0;

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles.values());
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return vehicles.get(id);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.put(counter, vehicle);
        counter++;
    }

    @Override
    public void addServiceToVehicle(ServiceManteinance serviceManteinance, int id) {
        vehicles.get(id).getServiceManteinances().add(serviceManteinance);
    }
}

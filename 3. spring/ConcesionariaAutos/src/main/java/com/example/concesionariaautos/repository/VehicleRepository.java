package com.example.concesionariaautos.repository;

import com.example.concesionariaautos.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehicleRepository {


    List<Vehicle> vehicles;

    public VehicleRepository(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }


    public Vehicle getVehicleById(int id){

        return vehicles.stream().filter(vehicle -> vehicle.getId() == id)
                .findFirst()
                .get();
    }
}

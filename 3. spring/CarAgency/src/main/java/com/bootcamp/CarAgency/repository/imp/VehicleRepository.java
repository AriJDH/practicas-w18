package com.bootcamp.CarAgency.repository.imp;

import com.bootcamp.CarAgency.entity.Vehicle;
import com.bootcamp.CarAgency.repository.IVehicleRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class VehicleRepository implements IVehicleRepository {

    private List<Vehicle> vehicles=new ArrayList<>();

    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> findByManufacturingDate(String manufacturingDate) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getManufacturingDate().equals(manufacturingDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByPrice(String price) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getPrice().equals(price))
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst().get();
    }
}

package com.playground.app.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.app.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class VehicleRepository implements IVehicleRepository {

    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleRepository() {
        loadlist();
    }

    private void loadlist() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:vehicles.json");
            vehicles = mapper.readValue(jsonFile, new TypeReference<List<Vehicle>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public void createVehicle(Vehicle vehicle) {
        if(vehicles.isEmpty()){
            vehicle.setId(1);
        } else
            vehicle.setId(vehicles.get(vehicles.size()-1).getId()+1);
        vehicles.add(vehicle);
    }

    @Override
    public Vehicle getById(Integer id){
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public List<Vehicle> getByDates(Date since, Date to) {
        List<Vehicle> auxListVehicleByDates = new ArrayList<>();
        for(Vehicle vehicle: vehicles){
            if(vehicle.getManufacturingDate().after(since) && vehicle.getManufacturingDate().before(to)){
                auxListVehicleByDates.add(vehicle);
            }
        }
        return auxListVehicleByDates;
    }

    @Override
    public List<Vehicle> getByPrice(Integer since, Integer to) {
        List<Vehicle> auxListVehicle = new ArrayList<>();
        for(Vehicle vehicle: vehicles){
            if(vehicle.getPrice() > since && vehicle.getPrice() < to){
                auxListVehicle.add(vehicle);
            }
        }
        return auxListVehicle;
    }

    @Override
    public void deleteById(Integer id) {
        Vehicle vehicle = getById(id);
        vehicles.remove(vehicle);
    }

    @Override
    public void update(Vehicle vehicle) {
        deleteById(vehicle.getId());
        vehicles.add(vehicle);
        //createVehicle(vehicle);
    }
}

package com.example.consecionaria.repository;

import com.example.consecionaria.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository

public class VehiclesRepositoryImp implements IVehiclesRespository{

    private List<Vehicle> vehicles = new ArrayList<>();

    public VehiclesRepositoryImp() {
        loadList();
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public void createdVehicle(Vehicle vehicle) {
        vehicle.setId(vehicles.size()+1);
        vehicles.add(vehicle);
    }

    @Override
    public Vehicle getById(Integer id){
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Vehicle> getByDate(Date since, Date to) {
        List<Vehicle> auxListVehicle = new ArrayList<>();
        for (Vehicle vehicle :vehicles) {
            if (vehicle.getManufacturingDate().after(since) && vehicle.getManufacturingDate().before(to)){

            }
        }
        return  null;
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:vehicles.json");
            vehicles = mapper.readValue(jsonFile, new TypeReference<List<Vehicle>>() {
            });
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }



}

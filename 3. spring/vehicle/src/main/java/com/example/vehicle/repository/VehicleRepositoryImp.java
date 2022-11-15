package com.example.vehicle.repository;

import com.example.vehicle.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class VehicleRepositoryImp implements IVehicleRepository{
    List<Vehicle> vehicles = new ArrayList<>();

    public VehicleRepositoryImp() {
        loadList();
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public Vehicle findById(Integer id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst().get();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if(vehicles.isEmpty()){
            vehicle.setId(1);
        } else vehicle.setId(vehicles.get(vehicles.size()-1).getId()+1);
        vehicles.add(vehicle);
    }

    @Override
    public List<Vehicle> findByPrices(Double since, Double to) {
        List<Vehicle> results = new ArrayList<>();
        for(Vehicle vehicle: vehicles){
            if(vehicle.getPrice()>since && vehicle.getPrice()<to){
                results.add(vehicle);
            }
        }
        return results;
    }

    @Override
    public void deleteVehicleById(Integer id) {
        Vehicle delele = vehicles.stream().filter(p->p.getId().equals(id)).findFirst().get();
        vehicles.remove(delele);
    }

    @Override
    public void updateVehicle(Integer id, Vehicle vehicle) {
        Vehicle vehicleUpdate = vehicles.stream().filter(p->p.getId().equals(id)).findFirst().get();

        vehicleUpdate.setBrand(vehicle.getBrand());
        vehicleUpdate.setModel(vehicle.getModel());
        vehicleUpdate.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleUpdate.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleUpdate.setDoors(vehicle.getDoors());
        vehicleUpdate.setPrice(vehicle.getPrice());
        vehicleUpdate.setCurrency(vehicle.getCurrency());
        vehicleUpdate.setServices(vehicle.getServices());
        vehicleUpdate.setCountOfOwners(vehicle.getCountOfOwners());
    }

    @Override
    public List<Vehicle> findByDates(LocalDate since, LocalDate to) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle vehicle: vehicles){
            if(vehicle.getManufacturingDate().isBefore(to) && vehicle.getManufacturingDate().isAfter(since)){
                results.add(vehicle);
            }
        }
        return results;
    }


    private void loadList(){
        //Otra opción:
        //ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        ObjectMapper mapper= new ObjectMapper();
        mapper.findAndRegisterModules();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:vehicles.json");
            vehicles = mapper.readValue(jsonFile, new TypeReference<List<Vehicle>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}

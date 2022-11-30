package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.request.VehicleRequestDto;
import com.example.concesionariaautos.dto.response.ResponseDto;
import com.example.concesionariaautos.dto.response.ResponseVehicleDto;
import com.example.concesionariaautos.dto.response.ResponseVehicleNoServicesDto;
import com.example.concesionariaautos.entity.Vehicle;
import com.example.concesionariaautos.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ResponseDto addVehicle(VehicleRequestDto vehicleRequestDto){

        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleRequestDto.getId());
        vehicle.setBrand(vehicleRequestDto.getBrand());
        vehicle.setModel(vehicleRequestDto.getModel());
        vehicle.setServices(vehicleRequestDto.getServices());
        vehicle.setCurrency(vehicleRequestDto.getCurrency());
        vehicle.setDoors(vehicleRequestDto.getDoors());
        vehicle.setPrice(vehicleRequestDto.getPrice());
        vehicle.setCountOfOwners(vehicleRequestDto.getCountOfOwners());
        vehicle.setManufacturingDate(vehicleRequestDto.getManufacturingDate());
        vehicle.setNumberOfKilometers(vehicleRequestDto.getNumberOfKilometers());

        //Vehicle vehicle = modelMapper.map(vehicleRequestDto, Vehicle.class);
        vehicleRepository.addVehicle(vehicle);

        return new ResponseDto("Vehicle added",200);

    }

    public List<ResponseVehicleNoServicesDto> getSelectVehicles(){
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        List<ResponseVehicleNoServicesDto> vehiclesDto = new ArrayList<>();
        for (Vehicle vehicle:vehicles){
            ResponseVehicleNoServicesDto vehicleNoServicesDto = new ResponseVehicleNoServicesDto();
            vehicleNoServicesDto.setModel(vehicle.getModel());
            vehicleNoServicesDto.setDoors(vehicle.getDoors());
            vehicleNoServicesDto.setCurrency(vehicle.getCurrency());
            vehicleNoServicesDto.setBrand(vehicle.getBrand());
            vehicleNoServicesDto.setPrice(vehicle.getPrice());
            vehicleNoServicesDto.setManufacturingDate(vehicle.getManufacturingDate());
            vehicleNoServicesDto.setCountOfOwners(vehicle.getCountOfOwners());
            vehicleNoServicesDto.setNumberOfKilometers(vehicle.getNumberOfKilometers());
            vehiclesDto.add(vehicleNoServicesDto);
        }

        return vehiclesDto;
    }

    public List<ResponseVehicleNoServicesDto> getVehiclesByPrice(double since, double to){
        List<Vehicle> vehiclesFilter = vehicleRepository.getVehicles()
                .stream()
                .filter(vehicle -> vehicle.getPrice() > since && vehicle.getPrice() < to)
                .collect(Collectors.toList());
        List<ResponseVehicleNoServicesDto> vehiclesDto = new ArrayList<>();
        for (Vehicle vehicle:vehiclesFilter){
            ResponseVehicleNoServicesDto vehicleNoServicesDto = new ResponseVehicleNoServicesDto();
            vehicleNoServicesDto.setModel(vehicle.getModel());
            vehicleNoServicesDto.setDoors(vehicle.getDoors());
            vehicleNoServicesDto.setCurrency(vehicle.getCurrency());
            vehicleNoServicesDto.setBrand(vehicle.getBrand());
            vehicleNoServicesDto.setPrice(vehicle.getPrice());
            vehicleNoServicesDto.setManufacturingDate(vehicle.getManufacturingDate());
            vehicleNoServicesDto.setCountOfOwners(vehicle.getCountOfOwners());
            vehicleNoServicesDto.setNumberOfKilometers(vehicle.getNumberOfKilometers());
            vehiclesDto.add(vehicleNoServicesDto);
        }
        return vehiclesDto;
    }

    public ResponseVehicleDto getVehicle(int id){
        Vehicle vehicle = vehicleRepository.getVehicleById(id);
        ResponseVehicleDto responseVehicleDto = new ResponseVehicleDto();
        responseVehicleDto.setServices(vehicle.getServices());
        responseVehicleDto.setBrand(vehicle.getBrand());
        responseVehicleDto.setDoors(vehicle.getDoors());
        responseVehicleDto.setCurrency(vehicle.getCurrency());
        responseVehicleDto.setModel(vehicle.getModel());
        responseVehicleDto.setPrice(vehicle.getPrice());
        responseVehicleDto.setId(vehicle.getId());
        responseVehicleDto.setManufacturingDate(vehicle.getManufacturingDate());
        responseVehicleDto.setCountOfOwners(vehicle.getCountOfOwners());
        responseVehicleDto.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        return responseVehicleDto;
    }


}

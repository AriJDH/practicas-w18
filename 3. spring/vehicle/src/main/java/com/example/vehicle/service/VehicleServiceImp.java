package com.example.vehicle.service;

import com.example.vehicle.dto.request.VehicleRequestDTO;
import com.example.vehicle.dto.response.VehicleResponseDTO;
import com.example.vehicle.entity.Vehicle;
import com.example.vehicle.repository.IVehicleRepository;
import com.example.vehicle.repository.VehicleRepositoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImp implements IVehicleService{
    private final IVehicleRepository vehicleRepository;

    private final ObjectMapper mapper;

    public VehicleServiceImp(VehicleRepositoryImp vehicleRepositoryImp, ObjectMapper mapper) {
        this.vehicleRepository = vehicleRepositoryImp;
        this.mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.findAndRegisterModules();
    }


    @Override
    public List<VehicleResponseDTO> findAll() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleResponseDTO> vehiclesResponseDTO = vehicles.stream()
                .map(p -> mapper.convertValue(p,VehicleResponseDTO.class))
                .collect(Collectors.toList());
        return vehiclesResponseDTO;
    }

    @Override
    public VehicleResponseDTO findById(Integer id) {
        Vehicle vehicle = vehicleRepository.findById(id);
        VehicleResponseDTO vehicleResponseDTO = mapper.convertValue(vehicle,VehicleResponseDTO.class);
        return vehicleResponseDTO;
    }

    @Override
    public void addVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = mapper.convertValue(vehicleRequestDTO,Vehicle.class);
        vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public List<VehicleResponseDTO> findByPrices(Double since, Double to) {
        List<Vehicle> vehicles = vehicleRepository.findByPrices(since,to);
        List<VehicleResponseDTO> vehiclesResponseDTO = vehicles.stream()
                .map(p -> mapper.convertValue(p,VehicleResponseDTO.class))
                .collect(Collectors.toList());

        return vehiclesResponseDTO;
    }

    @Override
    public void deleteVehicleById(Integer id) {
        vehicleRepository.deleteVehicleById(id);
    }

    @Override
    public void updateVehicle(Integer id, VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = mapper.convertValue(vehicleRequestDTO,Vehicle.class);
        vehicleRepository.updateVehicle(id, vehicle);
    }

    @Override
    public List<VehicleResponseDTO> findByDates(LocalDate since, LocalDate to) {
        List<Vehicle> vehicles = vehicleRepository.findByDates(since,to);
        List<VehicleResponseDTO> vehiclesResponseDTO = vehicles.stream()
                .map(p -> mapper.convertValue(p,VehicleResponseDTO.class))
                .collect(Collectors.toList());


        return vehiclesResponseDTO;
    }


}

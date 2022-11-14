package com.example.concesionaria.service;

import com.example.concesionaria.dto.ServiceDTO;
import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.dto.VehicleDTOres;
import com.example.concesionaria.entity.ServiceManteinance;
import com.example.concesionaria.entity.Vehicle;
import com.example.concesionaria.repository.IVehicleRepository;
import com.example.concesionaria.repository.VehicleRepository;
import com.example.concesionaria.util.HandleLocalDate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{
    private final IVehicleRepository vehicleRepository;
    private final ModelMapper mapper;


    public VehicleService(VehicleRepository vehicleRepository, ModelMapper mapper) {
        this.vehicleRepository = vehicleRepository;
        this.mapper = mapper;
    }

    @Override
    public void addVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapper.map(vehicleDTO, Vehicle.class);
        vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public void addServiceToVehicle(ServiceDTO serviceDTO, int vehicleId) {
        ServiceManteinance service = mapper.map(serviceDTO, ServiceManteinance.class);
        vehicleRepository.addServiceToVehicle(service, vehicleId);
    }

    @Override
    public List<VehicleDTOres> getVehicles() {
        List<VehicleDTOres> res = vehicleRepository.getVehicles()
                .stream()
                .map(v -> mapper.map(v, VehicleDTOres.class))
                .collect(Collectors.toList());
        return res;
    }

    @Override
    public List<VehicleDTOres> getVehiclesByDates(String since, String to) {
        LocalDate sinceDate = HandleLocalDate.parse(since);
        LocalDate toDate = HandleLocalDate.parse(to);
        List<Vehicle> vehicles = vehicleRepository.getVehicles();

        List<VehicleDTOres> res = vehicles
                .stream()
                .filter(v -> {
                    LocalDate manufacturingDate = HandleLocalDate.parse(v.getManufacturingDate());
                    return HandleLocalDate.compareDates(sinceDate, toDate, manufacturingDate);
                })
                .map(v -> mapper.map(v, VehicleDTOres.class))
                .collect(Collectors.toList());

        return res;
    }

    @Override
    public List<VehicleDTOres> getVehiclesByPrice(int since, int to) {
        List<Vehicle> vehicles = vehicleRepository.getVehicles();
        List<VehicleDTOres> res = vehicles
                .stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
                .map(v -> mapper.map(v, VehicleDTOres.class))
                .collect(Collectors.toList());
        return res;
    }

    @Override
    public VehicleDTO getVehicleById(int id) {
        Vehicle vehicle = vehicleRepository.getVehicleById(id);
        return mapper.map(vehicle, VehicleDTO.class);
    }
}

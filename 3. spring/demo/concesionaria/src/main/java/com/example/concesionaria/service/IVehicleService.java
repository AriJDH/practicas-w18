package com.example.concesionaria.service;

import com.example.concesionaria.dto.ServiceDTO;
import com.example.concesionaria.dto.VehicleDTO;
import com.example.concesionaria.dto.VehicleDTOres;

import java.util.List;

public interface IVehicleService {
    void addVehicle(VehicleDTO vehicleDTO);
    void addServiceToVehicle(ServiceDTO serviceDTO, int vehicleId);
    List<VehicleDTOres> getVehicles();
    List<VehicleDTOres> getVehiclesByDates(String since, String to);
    List<VehicleDTOres> getVehiclesByPrice(int since, int to);
    VehicleDTO getVehicleById(int id);

}

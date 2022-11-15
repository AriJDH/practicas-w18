package com.example.vehicle.service;

import com.example.vehicle.dto.request.VehicleRequestDTO;
import com.example.vehicle.dto.response.VehicleResponseDTO;
import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
    List<VehicleResponseDTO> findAll();
    VehicleResponseDTO findById(Integer id);

    void addVehicle(VehicleRequestDTO vehicleRequestDTO);

    List<VehicleResponseDTO> findByPrices(Double since, Double to);

    void deleteVehicleById(Integer id);

    void updateVehicle(Integer id, VehicleRequestDTO vehicleRequestDTO);

    List<VehicleResponseDTO> findByDates(LocalDate since, LocalDate to);

}

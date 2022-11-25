package com.jcundere.ejerciciopractico07c.service;

import com.jcundere.ejerciciopractico07c.dto.request.VehicleRequest;
import com.jcundere.ejerciciopractico07c.dto.response.VehicleResponse;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {

    VehicleResponse saveVehicle(VehicleRequest vehicleRequest);

    Optional<VehicleResponse> getVehicleById(Integer id);

    List<VehicleResponse> getAllVehicle();

    List<VehicleResponse> getAllVehicleByDateRange(String startDate, String endDate);

    List<VehicleResponse> getAllVehicleByPriceRange(Integer minValue, Integer maxValue);

}

package com.bootcamp.CarAgency.service;

import com.bootcamp.CarAgency.dto.view.VehicleFullDto;
import com.bootcamp.CarAgency.dto.view.VehicleWithoutServiceDto;
import com.bootcamp.CarAgency.entity.Vehicle;

import java.util.List;

public interface IVehicleService {

    void saveVehicle(VehicleFullDto vehicle);
    List<VehicleWithoutServiceDto> findAll();
    List<VehicleFullDto> findByManufacturingDate(String manufacturingDate);
    List<VehicleFullDto> findByPrice(String price);
    VehicleFullDto findById(Integer id);
}

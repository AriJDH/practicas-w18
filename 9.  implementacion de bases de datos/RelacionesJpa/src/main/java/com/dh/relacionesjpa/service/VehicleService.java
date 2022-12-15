package com.dh.relacionesjpa.service;

import com.dh.relacionesjpa.repository.IVehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService implements IVehicleService{

    private final IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }




}

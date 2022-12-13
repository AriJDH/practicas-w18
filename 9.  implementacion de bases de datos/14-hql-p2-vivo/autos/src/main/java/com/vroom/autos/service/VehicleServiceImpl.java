package com.vroom.autos.service;

import com.vroom.autos.dto.*;
import com.vroom.autos.entity.Vehicle;
import com.vroom.autos.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{
    private final IVehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public VehicleLicensePlateListResponse getVehicleLicensePlateList() {
        return new VehicleLicensePlateListResponse(
                vehicleRepository.findAll().stream()
                        .map(Vehicle::getLicensePlate)
                        .collect(Collectors.toList())
        );
//        return new VehicleLicensePlateListResponse(vehicleRepository.findAllLicensePlate());
    }

    @Override
    public VehicleLicensePlateMakeListResponse getVehicleLicensePlateMakeListOrderByFabricationYear() {
        return new VehicleLicensePlateMakeListResponse(
                vehicleRepository.findAllOrderByFabricationYear().stream()
                        .map(vehicle -> modelMapper.map(vehicle, VehicleLicensePlateMakeResponse.class))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public VehicleLicensePlateListResponse getVehicleLicensePlateWhereWheelCountGreaterThanAndFabricationYearIs() {
//        Integer year = 2012;
        Integer year = LocalDate.now().getYear();
        return new VehicleLicensePlateListResponse(
                vehicleRepository.findByWheelCountGreaterThanAndFabricationYearIs(
                        4, year)
                        .stream()
                        .map(Vehicle::getLicensePlate)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public VehicleLpMaMoListResponse getVehicleWhereAccidentMonetaryLossGreaterThan() {
        return new VehicleLpMaMoListResponse(
                vehicleRepository.findVehicleByAccidentMonetaryLossGreaterThan(10000.0).stream()
                        .map(vehicle -> modelMapper.map(vehicle, VehicleLpMaMoResponse.class))
                        .collect(Collectors.toList())
        );
    }
}

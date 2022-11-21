package com.playground.app.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.app.dto.request.VehicleDTOReq;
import com.playground.app.dto.response.VehicleDTOResp;
import com.playground.app.entity.Vehicle;
import com.playground.app.repository.IVehicleRepository;
import com.playground.app.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService{

    private final IVehicleRepository vehiclesRepository;
    private final ObjectMapper mapper;

    public VehicleService(VehicleRepository vehiclesRepositoryImpl, ObjectMapper mapper) {
        this.vehiclesRepository = vehiclesRepositoryImpl;
       // this.mapper = mapper;
        this.mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<VehicleDTOResp> getAll() {

        List<Vehicle> vehicles = vehiclesRepository.getAll();
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<VehicleDTOResp> vehiclesDTOResp = vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDTOResp.class))
                .collect(Collectors.toList());
        return vehiclesDTOResp;

    }

    @Override
    public void createVehicle(VehicleDTOReq vehicleDTOReq) {

        Vehicle vehicle = mapper.convertValue(vehicleDTOReq, Vehicle.class);
        vehiclesRepository.createVehicle(vehicle);

    }

    @Override
    public VehicleDTOResp getById(Integer id) {
       // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Vehicle vehicle = vehiclesRepository.getById(id);
        VehicleDTOResp vehicleDTOResp = mapper.convertValue(vehicle, VehicleDTOResp.class);
        return vehicleDTOResp;
    }

    @Override
    public List<VehicleDTOResp> getByDates(LocalDate since, LocalDate to) {

      //  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Vehicle> vehicleList = vehiclesRepository.getByDates(since, to);
        List<VehicleDTOResp> vehicleDTORespList = vehicleList.stream()
                .map(p -> mapper.convertValue(p,VehicleDTOResp.class))
                .collect(Collectors.toList());
        return vehicleDTORespList;
    }

    @Override
    public List<VehicleDTOResp> getByPrice(Integer since, Integer to) {

       // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Vehicle> vehicleList = vehiclesRepository.getByPrice(since, to);
        List<VehicleDTOResp> vehicleDTORespList = vehicleList.stream()
                .map(p -> mapper.convertValue(p,VehicleDTOResp.class))
                .collect(Collectors.toList());
        return vehicleDTORespList;

    }

    @Override
    public void deleteById(Integer id) {
        vehiclesRepository.deleteById(id);

    }

    @Override
    public void update(VehicleDTOReq vehicleDTOReq, Integer id) {
        Vehicle vehicle = mapper.convertValue(vehicleDTOReq, Vehicle.class);
        vehicle.setId(id);
        vehiclesRepository.update(vehicle);
    }
}

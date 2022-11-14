package com.example.consecionaria.service;

import com.example.consecionaria.dto.req.VehicleDTOReq;
import com.example.consecionaria.dto.resp.VehicleDTOResp;
import com.example.consecionaria.entity.Vehicle;
import com.example.consecionaria.repository.IVehiclesRespository;
import com.example.consecionaria.repository.VehiclesRepositoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class VehicleServiceImp implements IVehicleService{
    // Inyectamos dependencias de Vehicles Repository
    IVehiclesRespository vehiclesRespository;

    public VehicleServiceImp(VehiclesRepositoryImp vehiclesRespository) {
        this.vehiclesRespository = vehiclesRespository;
    }


    @Override
    public List<VehicleDTOResp> getAll() {

        List<Vehicle>vehicles  = vehiclesRespository.getAll();
        ObjectMapper op = new ObjectMapper();
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<VehicleDTOResp> vehicleDTOResp = vehicles.stream()
                .map(p -> op.convertValue(p,VehicleDTOResp.class))
                .collect(Collectors.toList());
        return vehicleDTOResp;
    }



    @Override
    public void createdVehicle(VehicleDTOReq vehicleDTOReq) {
        ObjectMapper op = new ObjectMapper();
        Vehicle vehicle= op.convertValue(vehicleDTOReq, Vehicle.class);
        vehiclesRespository.createdVehicle(vehicle);
    }

    @Override
    public VehicleDTOResp getById(Integer id) {
        ObjectMapper op = new ObjectMapper();
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Vehicle vehicle = vehiclesRespository.getById(id);
        VehicleDTOResp vehicleDTOResp = op.convertValue(vehiclesRespository, VehicleDTOResp.class);
        return vehicleDTOResp;
    }

    @Override
    public List<VehicleDTOResp> getByDate(Date since, Date to) {
        ObjectMapper op = new ObjectMapper();
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        List<Vehicle> vehiclesList = vehiclesRespository.getByDate(since, to);
        List<VehicleDTOResp> vehicleDTORespList = vehiclesList.stream()
                .map(p -> op.convertValue(p,VehicleDTOResp.class))
                .collect(Collectors.toList());
        return vehicleDTORespList;
    }


}

package com.playground.app.service;

import com.playground.app.dto.request.VehicleDTOReq;
import com.playground.app.dto.response.VehicleDTOResp;
import com.playground.app.entity.Vehicle;

import java.util.Date;
import java.util.List;

public interface IVehicleService {

    List<VehicleDTOResp> getAll();
    void createVehicle(VehicleDTOReq vehicleDTO);
    VehicleDTOResp getById(Integer id);
    List<VehicleDTOResp> getByDates(Date since, Date to);
    List<VehicleDTOResp> getByPrice(Integer since, Integer to);
    void deleteById(Integer id);
    void update(VehicleDTOReq vehicle, Integer id);
}

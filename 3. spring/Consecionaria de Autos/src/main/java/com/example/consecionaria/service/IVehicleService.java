package com.example.consecionaria.service;

import com.example.consecionaria.dto.req.VehicleDTOReq;
import com.example.consecionaria.dto.resp.VehicleDTOResp;

import java.util.Date;
import java.util.List;

public interface IVehicleService {

    public List<VehicleDTOResp> getAll();
    public void createdVehicle(VehicleDTOReq vehicleDTOResp);
    public VehicleDTOResp getById(Integer id);
    public List<VehicleDTOResp> getByDate(Date since, Date to);
}

package com.example.consecionaria.repository;


import com.example.consecionaria.entity.Vehicle;

import java.util.Date;
import java.util.List;

public interface IVehiclesRespository {
    public List<Vehicle> getAll();
    public void createdVehicle(Vehicle vehicle);
    public Vehicle getById(Integer id);
    public List<Vehicle> getByDate(Date since, Date to);

}

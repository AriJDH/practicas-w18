package com.ejerciciosPracticosP2Vivo.vehiculos.service;

import com.ejerciciosPracticosP2Vivo.vehiculos.dto.VehicleDTOReq;
import com.ejerciciosPracticosP2Vivo.vehiculos.dto.VehicleDTORes;

import java.util.Date;
import java.util.List;

public interface IVehicleService {
	
	void addVehicle(VehicleDTOReq vehicleDTO);
	List<VehicleDTORes> findAll();
	VehicleDTORes findById(Long id);
	List<VehicleDTORes> findByDates(Date since, Date to);
	List<VehicleDTORes> findByPrice(Double since, Double to);
	void deleteById(Long id);
	void update(VehicleDTOReq vehicleDTO, Long id);
	
}

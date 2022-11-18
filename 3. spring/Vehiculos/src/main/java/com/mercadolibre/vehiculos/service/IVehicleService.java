package com.mercadolibre.vehiculos.service;

import com.mercadolibre.vehiculos.dto.VehicleDTOReq;
import com.mercadolibre.vehiculos.dto.VehicleDTORes;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleService {
	
	void addVehicle(VehicleDTOReq vehicleDTO);
	List<VehicleDTORes> findAll();
	VehicleDTORes findById(Long id);
	List<VehicleDTORes> findByDates(LocalDate since, LocalDate to);
	List<VehicleDTORes> findByPrice(Double since, Double to);
	void deleteById(Long id);
	void update(VehicleDTOReq vehicleDTO, Long id);
	
}

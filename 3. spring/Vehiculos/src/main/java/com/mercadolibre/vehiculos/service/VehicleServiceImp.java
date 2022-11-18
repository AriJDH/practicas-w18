package com.mercadolibre.vehiculos.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.vehiculos.dto.VehicleDTOReq;
import com.mercadolibre.vehiculos.dto.VehicleDTORes;
import com.mercadolibre.vehiculos.entity.Vehicle;
import com.mercadolibre.vehiculos.repository.IVehicleRepository;
import com.mercadolibre.vehiculos.repository.VehicleRepositoryImp;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImp implements IVehicleService{
	
	// Atributos ----------------------------------------------------
	private final IVehicleRepository vehicleRepository; // Traemos el repositorio por constructor
	private final ObjectMapper mapper; // Object mapper para transformar entities en DTO
	
	// Constructor ---------------------------------------------------
	public VehicleServiceImp(VehicleRepositoryImp vehicleRepositoryImp,
							 ObjectMapper mapper) {
		this.vehicleRepository = vehicleRepositoryImp;
		this.mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.mapper.findAndRegisterModules();
	}
	
	// Métodos --------------------------------------------------------
	@Override
	public void addVehicle(VehicleDTOReq vehicleDTO) {
		// Transformamos el vehiculo que viene como DTO en una entity
		Vehicle vehicle = mapper.convertValue(vehicleDTO, Vehicle.class);
		// Le pasamos nuestra entity al repositorio para agregarla
		vehicleRepository.addVehicle(vehicle);
	}
	
	@Override
	public List<VehicleDTORes> findAll() {
		List<Vehicle> vehicleList = vehicleRepository.findAll();
		return vehicleList
						.stream()
						.map(vehicle -> mapper.convertValue(vehicle, VehicleDTORes.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public VehicleDTORes findById(Long id) {
		Vehicle vehicle = vehicleRepository.findById(id);
		return mapper.convertValue(vehicle, VehicleDTORes.class);
	}
	
	@Override
	public List<VehicleDTORes> findByDates(LocalDate since, LocalDate to) {
		List<Vehicle> vehicleList = vehicleRepository.findByDates(since, to);
		return vehicleList
						.stream()
						.map(vehicle -> mapper.convertValue(vehicle, VehicleDTORes.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public List<VehicleDTORes> findByPrice(Double since, Double to) {
		List<Vehicle> vehicleList = vehicleRepository.findByPrice(since, to);
		return vehicleList
						.stream()
						.map(vehicle -> mapper.convertValue(vehicle, VehicleDTORes.class))
						.collect(Collectors.toList());
	}
	
	@Override
	public void deleteById(Long id) {
		vehicleRepository.deleteById(id);
	}
	
	@Override
	public void update(VehicleDTOReq vehicleDTO, Long id) {
		Vehicle vehicle = mapper.convertValue(vehicleDTO, Vehicle.class);
		vehicle.setId(id);
		vehicleRepository.update(vehicle);
	}
}

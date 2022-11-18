package com.mercadolibre.vehiculos.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.vehiculos.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImp implements IVehicleRepository {
	
	// Nuestra base de datos de vehiculos
	List<Vehicle> vehicles = new ArrayList<>();

	// Constructor
	public VehicleRepositoryImp() {
		loadList(); // Llamamos al método para traer el JSON
	}

	// Leemos el JSON
	private void loadList() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		File jsonFile = null;
		try {
			jsonFile = ResourceUtils.getFile("classpath:vehicles.json");
			vehicles = mapper.readValue(jsonFile, new TypeReference<List<Vehicle>>() {
			});
		} catch (Exception ex) {
			System.out.println("No existe el archivo. " + ex.getMessage());
		}
	}
	// Métodos
	@Override
	public void addVehicle(Vehicle vehicle) {
		// Si la lista está vacía, seteamos en 1
		if(vehicles.isEmpty()){
			vehicle.setId(1L);
			// Sino tomamos el ultimo y le agregamos el siguiente
		} else vehicle.setId(vehicles.get(vehicles.size()-1).getId()+1);
		vehicles.add(vehicle);
	}
	
	@Override
	public List<Vehicle> findAll() {
		return vehicles;
	}
	
	@Override
	public Vehicle findById(Long id) {
		return vehicles
						.stream()
						.filter(v -> v.getId().equals(id))
						.findFirst()
						.orElseThrow();
	}
	
	@Override
	public List<Vehicle> findByDates(LocalDate since, LocalDate to) {
		List<Vehicle> vehicleListByDates = new ArrayList<>();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getManufacturingDate().isAfter(since) &&
							vehicle.getManufacturingDate().isBefore(to)) {
				vehicleListByDates.add(vehicle);
			}
		}
		return vehicleListByDates;
	}
	
	@Override
	public List<Vehicle> findByPrice(Double since, Double to) {
		List<Vehicle> vehicleListByPrice = new ArrayList<>();
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getPrice() > since && vehicle.getPrice() < to){
				vehicleListByPrice.add(vehicle);
			}
		}
		return vehicleListByPrice;
	}
	
	@Override
	public void deleteById(Long id) {
		Vehicle vehicle = findById(id);
		vehicles.remove(vehicle);
	}
	
	@Override
	public void update(Vehicle vehicle) {
		deleteById(vehicle.getId());
    vehicles.add(vehicle);
 	}
}

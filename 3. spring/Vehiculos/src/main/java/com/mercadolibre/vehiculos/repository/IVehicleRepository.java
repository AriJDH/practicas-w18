package com.mercadolibre.vehiculos.repository;

import com.mercadolibre.vehiculos.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository{
	
	void addVehicle(Vehicle vehicle); // Agrega
	List<Vehicle> findAll(); // Listar todos
	Vehicle findById(Long id); // Busca por ID
	List<Vehicle> findByDates(LocalDate since, LocalDate to); // Busca por fechas desde ... hasta...
	List<Vehicle> findByPrice(Double since, Double to); // Busca por precios desde ... hasta ...
  void deleteById(Long id);	// Eliminar por id
	void update(Vehicle vehicle); // Modificar vehiculo
	
}

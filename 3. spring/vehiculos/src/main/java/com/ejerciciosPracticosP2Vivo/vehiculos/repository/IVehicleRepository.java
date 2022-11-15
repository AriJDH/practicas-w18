package com.ejerciciosPracticosP2Vivo.vehiculos.repository;

import com.ejerciciosPracticosP2Vivo.vehiculos.entity.Vehicle;

import java.util.Date;
import java.util.List;

public interface IVehicleRepository{
	
	void addVehicle(Vehicle vehicle); // Agrega
	List<Vehicle> findAll(); // Listar todos
	Vehicle findById(Long id); // Busca por ID
	List<Vehicle> findByDates(Date since, Date to); // Busca por fechas desde ... hasta...
	List<Vehicle> findByPrice(Double since, Double to); // Busca por precios desde ... hasta ...
  void deleteById(Long id);	// Eliminar por id
	void update(Vehicle vehicle); // Modificar vehiculo
	
}

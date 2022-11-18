package com.mercadolibre.vehiculos.controller;

import com.mercadolibre.vehiculos.dto.VehicleDTOReq;
import com.mercadolibre.vehiculos.dto.VehicleDTORes;
import com.mercadolibre.vehiculos.service.IVehicleService;
import com.mercadolibre.vehiculos.service.VehicleServiceImp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {
	
	// Traemos el service
	private IVehicleService vehicleService;
	
	public VehicleController(VehicleServiceImp vehicleServiceImp) {
		this.vehicleService = vehicleServiceImp;
	}
	
	// POST
	@PostMapping
	public ResponseEntity<String> createVehicle(@RequestBody VehicleDTOReq vehicleDTOReq) {
		vehicleService.addVehicle(vehicleDTOReq);
		return new ResponseEntity<>("Vehiculo creado", HttpStatus.CREATED);
	}
	
	// GET ALL
	@GetMapping
	public ResponseEntity<List<VehicleDTORes>> findAll() {
		List<VehicleDTORes> vehicleDTOResList = vehicleService.findAll();
		return new ResponseEntity<>(vehicleDTOResList, HttpStatus.OK);
	}
	
	// GET BY DATES
	@GetMapping("/dates")
	public ResponseEntity<List<VehicleDTORes>> findByDates(
					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate since,
					@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to
	) {
		List<VehicleDTORes> vehicleDTOResList = vehicleService.findByDates(since, to);
		return new ResponseEntity<>(vehicleDTOResList, HttpStatus.OK);
	}
	
	// GET BY PRICE
	@GetMapping("/prices")
	public ResponseEntity<List<VehicleDTORes>> getByPrice(
					@RequestParam Double since, @RequestParam Double to) {
		return new ResponseEntity<>(vehicleService.findByPrice(since, to), HttpStatus.OK);
	}
	
	// GET BY ID
	@GetMapping("/{id}")
	public ResponseEntity<VehicleDTORes> getById(@PathVariable Long id) {
		return new ResponseEntity<>(vehicleService.findById(id), HttpStatus.OK);
	}
	
	// DELETE BY ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		vehicleService.deleteById(id);
		return new ResponseEntity<>("Eliminado con éxito", HttpStatus.OK);
	}
	
	// UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody VehicleDTOReq vehicleDTOReq,
	                                     @PathVariable Long id) {
		vehicleService.update(vehicleDTOReq, id);
		return new ResponseEntity<>("Modificado con éxito", HttpStatus.OK);
	}
	
	
} // Cierre
	


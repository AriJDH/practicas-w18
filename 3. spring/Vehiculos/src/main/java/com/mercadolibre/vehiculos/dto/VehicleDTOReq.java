package com.mercadolibre.vehiculos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.vehiculos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VehicleDTOReq {
	
	private String brand;
	private String model;
	@JsonFormat(pattern = "yyyy-MM-dd") // Anotacion de Jackson para cambiar formato
	private LocalDate manufacturingDate;
	private Integer numberOfKilometers;
	private Integer doors;
	private Double price;
	private String currency;
	private List<Service> services;
	private Integer countOfOwners;
	
}

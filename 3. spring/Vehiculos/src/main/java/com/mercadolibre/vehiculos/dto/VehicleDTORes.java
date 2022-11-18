package com.mercadolibre.vehiculos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor // Constructor con todos los argumentos
@NoArgsConstructor // Constructor sin argumentos
@Getter
public class VehicleDTORes {
	// Atributos
	private Long id;
	private String brand;
	private String model;
	@JsonFormat(pattern = "yyyy-MM-dd") // Anotacion de Jackson para cambiar formato
	private LocalDate manufacturingDate;
	private Integer numberOfKilometers;
	private Integer doors;
	private Double price;
	private String currency;
	private Integer countOfOwners;
	
}

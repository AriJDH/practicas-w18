package com.ejerciciosPracticosP2Vivo.vehiculos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
	//Atributos
	private Long id;
	private String brand;
	private String model;
	@JsonFormat(pattern = "yyyy-MM-dd") // Anotacion de Jackson para cambiar formato
	private Date manufacturingDate;
	private Integer numberOfKilometers;
	private Integer doors;
	private Double price;
	private String currency;
	private List<Service> services;
	private Integer countOfOwners;
	
}

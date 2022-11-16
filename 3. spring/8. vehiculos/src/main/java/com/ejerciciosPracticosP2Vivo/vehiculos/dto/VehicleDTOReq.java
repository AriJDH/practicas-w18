package com.ejerciciosPracticosP2Vivo.vehiculos.dto;

import com.ejerciciosPracticosP2Vivo.vehiculos.entity.Service;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VehicleDTOReq {
	
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

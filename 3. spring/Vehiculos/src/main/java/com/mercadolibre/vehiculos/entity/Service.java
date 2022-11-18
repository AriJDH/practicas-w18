package com.mercadolibre.vehiculos.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {
	
	// Atributos
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private Integer kilometers;
	private String descriptions;
	
}

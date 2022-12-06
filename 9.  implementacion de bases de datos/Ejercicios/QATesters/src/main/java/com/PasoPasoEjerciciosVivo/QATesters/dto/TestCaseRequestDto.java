package com.PasoPasoEjerciciosVivo.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseRequestDto {
	
	private Long idCase;
	private String description;
	private Boolean tested;
	private Boolean passed;
	private int numberOfTries;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate lastUpdate;
	
}

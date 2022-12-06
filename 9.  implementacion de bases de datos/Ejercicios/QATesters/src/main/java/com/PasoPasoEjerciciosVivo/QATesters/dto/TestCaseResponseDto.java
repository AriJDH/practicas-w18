package com.PasoPasoEjerciciosVivo.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseResponseDto {
	
	private Long idCase;
	private String description;
	private Boolean tested;
	private Boolean passed;
	private int numberOfTries;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate lastUpdate;
	
}

package com.PasoPasoEjerciciosVivo.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCaseDto {
	
	private Long idCase;
	private String description;
	private boolean tested;
	private boolean passed;
	private int numberOfTries;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate lastUpdate;
	
}

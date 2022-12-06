package com.PasoPasoEjerciciosVivo.QATesters.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TestCase {
	
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_case")
	private Long idCase;
	private String description;
	private Boolean tested;
	private Boolean passed;
	@Column(name="number_of_tries")
	private int numberOfTries;
	@Column(name="last_update")
	private LocalDate lastUpdate;
	
}

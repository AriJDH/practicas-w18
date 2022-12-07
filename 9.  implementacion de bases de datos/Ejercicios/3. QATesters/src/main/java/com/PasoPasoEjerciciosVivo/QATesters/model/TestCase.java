package com.PasoPasoEjerciciosVivo.QATesters.model;

import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
public class TestCase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_case")
	private Long idCase;
	private String description;
	private boolean tested;
	private boolean passed;
	@Column(name = "number_of_tries")
	private int numberOfTries;
	@Column(name = "last_update")
	private LocalDate lastUpdate;
	
}

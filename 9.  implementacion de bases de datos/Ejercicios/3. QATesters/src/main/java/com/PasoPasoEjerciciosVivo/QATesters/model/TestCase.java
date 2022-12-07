package com.PasoPasoEjerciciosVivo.QATesters.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
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
	
	public void setIdCase(Long idCase) {
		this.idCase = idCase;
	}
}

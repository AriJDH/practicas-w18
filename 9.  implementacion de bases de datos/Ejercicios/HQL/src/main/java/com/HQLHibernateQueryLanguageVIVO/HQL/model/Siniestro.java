package com.HQLHibernateQueryLanguageVIVO.HQL.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Siniestro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSiniestro;
	private LocalDate fechaSiniestro;
	private String perdidaEconomica;
	@ManyToOne
	@JoinColumn(name="siniestroList",referencedColumnName = "idVehiculo")
	private Vehiculo vehiculo;
	
}

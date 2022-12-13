package com.HQLHibernateQueryLanguageVIVO.HQL.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVehiculo;
	private String patente;
	private String marca;
	private String modelo;
	private Integer anioFabricacion;
	private Integer cantRuedas;
	@OneToMany(mappedBy = "vehiculo")
	private Set<Siniestro> siniestroList = new HashSet<>();
	
}

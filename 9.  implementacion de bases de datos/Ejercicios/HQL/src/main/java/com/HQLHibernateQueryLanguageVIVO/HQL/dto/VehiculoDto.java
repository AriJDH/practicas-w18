package com.HQLHibernateQueryLanguageVIVO.HQL.dto;

import com.HQLHibernateQueryLanguageVIVO.HQL.model.Siniestro;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class VehiculoDto {
	private Long idVehiculo;
	private String patente;
	private String marca;
	private String modelo;
	private Integer anioFabricacion;
	private Integer cantRuedas;
	private Set<Siniestro> siniestroList = new HashSet<>();
	
}

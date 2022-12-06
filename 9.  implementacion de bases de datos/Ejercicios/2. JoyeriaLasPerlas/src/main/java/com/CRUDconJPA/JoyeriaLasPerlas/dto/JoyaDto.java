package com.CRUDconJPA.JoyeriaLasPerlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JoyaDto {
	
	private Long id;
	private String nombre;
	private String material;
	private double peso;
	private String particularidad;
	@JsonProperty("posee_piedra")
	private boolean poseePiedra;
	private boolean ventaONo;
	
}

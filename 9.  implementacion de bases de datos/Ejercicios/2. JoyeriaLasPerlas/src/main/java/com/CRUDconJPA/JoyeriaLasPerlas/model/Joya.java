package com.CRUDconJPA.JoyeriaLasPerlas.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Joya {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "nro_identificatorio")
	private Long id;
	private String nombre;
	private String material;
	private double peso;
	private String particularidad;
	@Column(name = "posee_piedra")
	private boolean poseePiedra;
	private boolean ventaONo;
	
	public boolean isVentaONo() {
		return ventaONo;
	}
	
	public void setVentaONo(boolean ventaONo) {
		this.ventaONo = ventaONo;
	}
}

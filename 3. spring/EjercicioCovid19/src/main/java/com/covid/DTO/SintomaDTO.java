package com.covid.DTO;

public class SintomaDTO {
	
	public SintomaDTO(String nombre, int nivel_de_gravedad) {
		super();
		this.nombre = nombre;
		this.nivel_de_gravedad = nivel_de_gravedad;
	}
	
	private String nombre;
	private int nivel_de_gravedad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivel_de_gravedad() {
		return nivel_de_gravedad;
	}
	public void setNivel_de_gravedad(int nivel_de_gravedad) {
		this.nivel_de_gravedad = nivel_de_gravedad;
	}

}

package com.covid.DTO;

public class PersonaDTO {
	
	public PersonaDTO(String nombre, String apellidol, int edad) {
		super();
		this.nombre = nombre;
		this.apellidol = apellidol;
		this.edad = edad;
	}
	
	private String nombre;
	private String apellidol;
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidol() {
		return apellidol;
	}
	public void setApellidol(String apellidol) {
		this.apellidol = apellidol;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}

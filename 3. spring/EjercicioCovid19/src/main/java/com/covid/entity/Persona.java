package com.covid.entity;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	
	public Persona(int id, String nombre, String apellidol, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidol = apellidol;
		this.edad = edad;
	}
	
	private int id;
	private String nombre;
	private String apellidol;
	private int edad;
	
	private List<Sintoma> sintomas = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public List<Sintoma> getSintomas() {
		return sintomas;
	}
	public void setSintomas(List<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

}

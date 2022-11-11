package com.food.DTO;

import java.util.List;

import com.food.model.Ingrediente;

public class PlatoDTO {
	
	public PlatoDTO(String nombre, int pesoEnGramo, List<Ingrediente> ingredientes) {
		super();
		this.nombre = nombre;
		this.pesoEnGramo = pesoEnGramo;
		this.ingredientes = ingredientes;
	}
	
	private String nombre;
	private int pesoEnGramo;
	private List<Ingrediente> ingredientes;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPesoEnGramo() {
		return pesoEnGramo;
	}
	public void setPesoEnGramo(int pesoEnGramo) {
		this.pesoEnGramo = pesoEnGramo;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
}

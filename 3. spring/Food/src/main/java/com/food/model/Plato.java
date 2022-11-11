package com.food.model;

import java.util.List;
import java.util.OptionalInt;

public class Plato {
	
	public Plato(String nombre, int pesoEnGramo, List<Ingrediente> ingredientes) {
		super();
		this.nombre = nombre;
		this.pesoEnGramo = pesoEnGramo;
		this.ingredientes = ingredientes;
	}
	
	private String nombre;
	private int pesoEnGramo;
	private List<Ingrediente> ingredientes;
	
	public int calcularCalorias() {
		
		return ingredientes.stream().mapToInt(i -> i.getCalories()).sum();
	}
	
	public int getIngredienteConMayorCantidadDeCalorias() {
		
		 int max = ingredientes
			      .stream()
			      .mapToInt(v -> v.getCalories())
			      .max()
			      .getAsInt();
		 
		 return max;
		
	}
	
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

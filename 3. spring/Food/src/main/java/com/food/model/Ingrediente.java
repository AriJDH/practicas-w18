package com.food.model;

public class Ingrediente {
	
	public Ingrediente(String name, int calories) {
		super();
		this.name = name;
		this.calories = calories;
	}
	
	public Ingrediente() {
	}

	private String name;
	private int calories;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	

}

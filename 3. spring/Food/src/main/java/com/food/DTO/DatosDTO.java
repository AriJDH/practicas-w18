package com.food.DTO;

import java.util.List;

import com.food.model.Ingrediente;

public class DatosDTO {
	
	public DatosDTO(String caloriasDelPlato, List<Ingrediente> ingredietnes, String ingredienteConMayorCaloria) {
		super();
		this.caloriasDelPlato = caloriasDelPlato;
		this.ingredietnes = ingredietnes;
		this.ingredienteConMayorCaloria = ingredienteConMayorCaloria;
	}

	public DatosDTO() {
	}

	private String caloriasDelPlato;
	
	private List<Ingrediente> ingredietnes;
	
	private String ingredienteConMayorCaloria;

	public String getCaloriasDelPlato() {
		return caloriasDelPlato;
	}

	public void setCaloriasDelPlato(String caloriasDelPlato) {
		this.caloriasDelPlato = caloriasDelPlato;
	}

	public List<Ingrediente> getIngredietnes() {
		return ingredietnes;
	}

	public void setIngredietnes(List<Ingrediente> ingredietnes) {
		this.ingredietnes = ingredietnes;
	}

	public String getIngredienteConMayorCaloria() {
		return ingredienteConMayorCaloria;
	}

	public void setIngredienteConMayorCaloria(String ingredienteConMayorCaloria) {
		this.ingredienteConMayorCaloria = ingredienteConMayorCaloria;
	}
	
	

}

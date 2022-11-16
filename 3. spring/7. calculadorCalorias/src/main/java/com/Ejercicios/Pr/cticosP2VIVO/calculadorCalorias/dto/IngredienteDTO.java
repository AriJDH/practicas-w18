package com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDTO {
	private String name;
	private int calories;
}
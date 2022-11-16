package com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingrediente {
	private String name;
	private int calories;
}

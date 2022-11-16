package com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoRequestDTO {
	private String nombre;
	private List<String> ingredientes;
	private double gramos;
}

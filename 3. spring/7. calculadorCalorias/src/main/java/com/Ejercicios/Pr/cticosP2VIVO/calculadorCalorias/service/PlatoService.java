package com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.service;

import com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.dto.PlatoDTO;
import com.Ejercicios.Pr.cticosP2VIVO.calculadorCalorias.dto.PlatoRequestDTO;


import java.util.List;

public interface PlatoService {
	PlatoDTO getPlatoDTO(PlatoRequestDTO platoRequestDTO);
	List<PlatoDTO> getPlatosDTOsFromList(List<PlatoRequestDTO> platoRequestDTOS);
}

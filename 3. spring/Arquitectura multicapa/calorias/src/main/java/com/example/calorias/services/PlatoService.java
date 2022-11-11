package com.example.calorias.services;

import com.example.calorias.DTOs.PlatoDTO;
import com.example.calorias.DTOs.PlatoRequestDTO;

import java.util.List;

public interface PlatoService {
    PlatoDTO getPlatoDTO(PlatoRequestDTO platoRequestDTO);
    List<PlatoDTO> getPlatosDTOsFromList(List<PlatoRequestDTO> platoRequestDTOS);
}

package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.request.PlatoRequestDTO;
import com.example.calculadoracalorias.dto.response.PlatoResponseAddOkDTO;
import com.example.calculadoracalorias.dto.response.PlatoResponseDTO;

import java.util.List;

public interface IServicePlatos {
    PlatoResponseAddOkDTO add(PlatoRequestDTO plato);
    List<PlatoResponseDTO> listAll();
    PlatoResponseDTO findByName(String name);
}

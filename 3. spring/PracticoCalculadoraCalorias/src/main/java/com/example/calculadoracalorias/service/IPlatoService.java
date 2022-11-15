package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.request.PlatoRequestDto;
import com.example.calculadoracalorias.dto.response.PlatoResponseDto;
import com.example.calculadoracalorias.entity.Plato;

import java.util.List;

public interface IPlatoService {

    PlatoResponseDto platoCalorias(String menu, float peso);
    List<PlatoResponseDto> listaPlatoCalorias(float peso);
}

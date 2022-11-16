package com.example.edad_persona.service;

import com.example.edad_persona.dto.DeporteDto;
import com.example.edad_persona.repository.DeporteRespositoryImpl;

import java.util.List;

public interface DeporteService {

    List<DeporteDto> findAll();

    DeporteDto findByName(String name);
}

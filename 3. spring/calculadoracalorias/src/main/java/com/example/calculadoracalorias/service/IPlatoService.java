package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.PlatoDto;

public interface IPlatoService {
    PlatoDto consultarPlato(String nombre, Integer peso);
}

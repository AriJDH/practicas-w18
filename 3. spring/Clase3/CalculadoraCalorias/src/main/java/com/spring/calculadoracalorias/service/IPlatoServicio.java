package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.dto.PlatoDTO;

public interface IPlatoServicio {
    PlatoDTO buscarPlato(String name, int gramos);
}

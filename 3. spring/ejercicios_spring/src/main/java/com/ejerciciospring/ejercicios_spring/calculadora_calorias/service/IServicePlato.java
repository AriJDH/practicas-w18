package com.ejerciciospring.ejercicios_spring.calculadora_calorias.service;

import com.ejerciciospring.ejercicios_spring.calculadora_calorias.dto.PlatoDTO;

public interface IServicePlato {

    PlatoDTO consultarPlato(String nombre, Integer peso);
}

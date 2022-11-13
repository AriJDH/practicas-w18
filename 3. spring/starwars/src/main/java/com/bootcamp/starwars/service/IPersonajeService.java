package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersojeDto;

import java.util.List;

public interface IPersonajeService {

    List<PersojeDto> findByName(String name);
}

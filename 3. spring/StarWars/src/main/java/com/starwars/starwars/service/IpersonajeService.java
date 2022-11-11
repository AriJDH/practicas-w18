package com.starwars.starwars.service;

import com.starwars.starwars.dto.PersonajeDto;

import java.util.List;

public interface IpersonajeService {

    public List<PersonajeDto> findByName(String name);

}

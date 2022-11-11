package com.kotor.starwars.service;

import com.kotor.starwars.dto.response.PersonajeDTORes;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTORes> getPeople(String name);
}

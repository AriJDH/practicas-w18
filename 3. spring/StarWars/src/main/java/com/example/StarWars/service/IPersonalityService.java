package com.example.StarWars.service;

import com.example.StarWars.dto.response.PersonalityDTO;

import java.util.List;

public interface IPersonalityService {
    List<PersonalityDTO> getPersonalitys(String name);
}

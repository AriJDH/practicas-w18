package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.repository.PersonajeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PersonajeServiceImpl implements IPersonajeService {
    @Autowired
    IPersonajeRepository personajesRepository;

    @Override
    public List<PersonajeDTO> getPersonajesByName(String name) {

        List<PersonajeDTO> personajeDTOList = personajesRepository
                .findByName(name)
                .stream()
                .map(p-> new PersonajeDTO(
                        p.getName(),
                        p.getHeight(),
                        p.getMass(),
                        p.getGender(),
                        p.getHomeworld(),
                        p.getSpecies()
                )).collect(Collectors.toList());
        return personajeDTOList;



    }
}

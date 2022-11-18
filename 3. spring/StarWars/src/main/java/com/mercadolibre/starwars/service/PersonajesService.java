package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.repository.IPersonajesRepository;
import com.mercadolibre.starwars.repository.PersonajesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajesService implements IPersonajesService {
    IPersonajesRepository personajesRepository;

    public PersonajesService(PersonajesRepository personajesRepository) {
        this.personajesRepository = personajesRepository;
    }

    @Override
    public List<PersonajeDTO> getAll() {
        List<PersonajeDTO> personajeDTOList = personajesRepository.findAll()
                .stream()
                .map(p-> new PersonajeDTO(
                        p.getName(),
                        p.getHeight(),
                        p.getMass(),
                        p.getGender(),
                        p.getHomeworld(),
                        p.getSpecies()))
                .collect(Collectors.toList());
        return personajeDTOList;
    }

    @Override
    public List<PersonajeDTO> getByName(String name) {
        List<PersonajeDTO> personajeDTOList = personajesRepository
                        .findByName(name)
                        .stream()
                        .map(p-> new PersonajeDTO(
                                p.getName(),
                                p.getHeight(),
                                p.getMass(),
                                p.getGender(),
                                p.getHomeworld(),
                                p.getSpecies()))
                        .collect(Collectors.toList());
        return personajeDTOList;
    }
}

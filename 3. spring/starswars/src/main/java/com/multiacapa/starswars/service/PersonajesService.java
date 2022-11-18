package com.multiacapa.starswars.service;

import com.multiacapa.starswars.dto.PersonajeDTOres;
import com.multiacapa.starswars.repository.IPersonajesRepository;
import com.multiacapa.starswars.repository.PersonajesRepository;
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
    public List<PersonajeDTOres> getAll() {
        List<PersonajeDTOres> personajeDTOList = personajesRepository.findAll()
                .stream()
                .map(p-> new PersonajeDTOres(
                        p.getName(),
                        p.getHeight(),
                        p.getMass(),
                        p.getGender(),
                        p.getHomeWorld(),
                        p.getSpecies()))
                .collect(Collectors.toList());
        return personajeDTOList;
    }

    @Override
    public List<PersonajeDTOres> getByName(String name) {
        List<PersonajeDTOres> personajeDTOList = personajesRepository
                .findByName(name)
                .stream()
                .map(p-> new PersonajeDTOres(
                        p.getName(),
                        p.getHeight(),
                        p.getMass(),
                        p.getGender(),
                        p.getHomeWorld(),
                        p.getSpecies()))
                .collect(Collectors.toList());
        return personajeDTOList;
    }
}

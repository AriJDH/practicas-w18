package com.jcundere.ejerciciopractico06.service;

import com.jcundere.ejerciciopractico06.dto.response.PersonajeResponse;
import com.jcundere.ejerciciopractico06.entity.PersonajeEntity;
import com.jcundere.ejerciciopractico06.repository.IPersonajeRepository;
import com.jcundere.ejerciciopractico06.util.mapper.PersonajeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonajeServiceImpl implements IPersonajeService {

    private final IPersonajeRepository personajeRepository;

    @Override
    public List<PersonajeResponse> searchPersonajeListByName(String name) {

        List<PersonajeEntity> personajeEntityList = personajeRepository.searchByName(name);
        List<PersonajeResponse> personajeResponseList = PersonajeMapper.entityList2ResponseList(personajeEntityList);

        return personajeResponseList;
    }

}

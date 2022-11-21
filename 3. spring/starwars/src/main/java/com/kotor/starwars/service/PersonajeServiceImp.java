package com.kotor.starwars.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.kotor.starwars.dto.response.PersonajeDTORes;
import com.kotor.starwars.entity.Personaje;
import com.kotor.starwars.repository.IPersonajeRepository;
import com.kotor.starwars.repository.PersonajeRepositoryImp;
import com.kotor.starwars.utils.EmptyStringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService {

    @Autowired
    private IPersonajeRepository personajeRepository = new PersonajeRepositoryImp();

    @Override
    public List<PersonajeDTORes> getPeople(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false);
        SimpleModule simpleModule = new SimpleModule().addDeserializer(Integer.class, new EmptyStringDeserializer());
        objectMapper.registerModule(simpleModule);

        List<Personaje> personList = personajeRepository.findByName(name);
        System.out.println(personList);
        List<PersonajeDTORes> personajeDTORes = personList.stream()
                .map(person -> objectMapper.convertValue(person, PersonajeDTORes.class))
                .collect(Collectors.toList());

        return personajeDTORes;
    }
}

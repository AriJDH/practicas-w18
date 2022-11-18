package com.example.covid.service;

import com.example.covid.dto.PersonDTORes;
import com.example.covid.entity.Person;
import com.example.covid.repository.IPersonaRepository;
import com.example.covid.repository.PersonaRepositoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImp implements IPersonService {
    private final IPersonaRepository personaRepository;

    private final ObjectMapper mapper;

    public PersonaServiceImp(PersonaRepositoryImp personaRepositoryImp, ObjectMapper mapper) {
        this.personaRepository = personaRepositoryImp;
        this.mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.findAndRegisterModules();
    }

    @Override
    public List<PersonDTORes> findRiskPerson() {
        List<Person> persons = personaRepository.findRiskPerson();
        return persons.stream().map(person -> mapper.convertValue(person, PersonDTORes.class)).collect(Collectors.toList());
    }
}
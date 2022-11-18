package com.example.StarWars.service;

import com.example.StarWars.dto.response.PersonalityDTO;
import com.example.StarWars.entity.Personality;
import com.example.StarWars.repository.IPersonalityRepository;
import com.example.StarWars.repository.PersonalityRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalityServiceImp implements IPersonalityService {
    private IPersonalityRepository personalityRepository = new PersonalityRepositoryImp();

    @Override
    public List<PersonalityDTO> getPersonalitys(String name) {
        ObjectMapper op = new ObjectMapper();
        List<Personality> personalities = personalityRepository.findAllByName(name);
        List<PersonalityDTO> personalityDTO = personalities.stream()
                .map(p -> op.convertValue(p,PersonalityDTO.class))
                .collect(Collectors.toList());

        return personalityDTO;
    }

}

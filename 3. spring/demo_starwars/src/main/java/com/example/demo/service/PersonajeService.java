package com.example.demo.service;

import com.example.demo.dto.response.PersonajeDTO;
import com.example.demo.entity.Personaje;
import com.example.demo.repository.IPersonajeRepository;
import com.example.demo.repository.PersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@Service
public class PersonajeService implements IPersonajeService{

    private IPersonajeRepository personajeRepository = new PersonajeRepository();

    @Override
    public List<PersonajeDTO> getPersonaje(String name) {
        List<Personaje> personajeList = personajeRepository.findAll();
        List<PersonajeDTO> personajeDTOList = new ArrayList<>();

        personajeList = personajeList.stream().filter(f->f.getName().contains(name)).collect(Collectors.toList());

        if (personajeList.size() > 0) {
            for (Personaje p: personajeList) {
                PersonajeDTO personajeDTO = new PersonajeDTO();
                personajeDTO.setGender(p.getGender());
                personajeDTO.setHomeworld(p.getHomeworld());
                personajeDTO.setName(p.getName());
                personajeDTO.setSpecies(p.getSpecies());
                if (p.getHeight().chars().allMatch(Character ::isDigit)){
                    personajeDTO.setHeight(Integer.parseInt(p.getHeight()));
                }
                else{
                    personajeDTO.setHeight(null);
                }
                if (p.getMass().chars().allMatch(Character ::isDigit)){
                    personajeDTO.setMass(Integer.parseInt(p.getMass()));
                }
                else{
                    personajeDTO.setMass(null);
                }
                personajeDTOList.add(personajeDTO);
            }
        }

        return personajeDTOList;
    }
}

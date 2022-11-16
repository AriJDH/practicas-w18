package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.repository.PersonajeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService {
    private IPersonajeRepository personajeRepository = new PersonajeRepository();

    @Override
    public List<PersonajeDTO> getChars(String busqueda) {
        List<Personaje> listaChar = personajeRepository.getChars(busqueda);
        ObjectMapper om = new ObjectMapper();
        List<PersonajeDTO> retorno = listaChar.stream().map( p-> om.convertValue(p,PersonajeDTO.class)).collect(Collectors.toList());
        return retorno;
    }
}

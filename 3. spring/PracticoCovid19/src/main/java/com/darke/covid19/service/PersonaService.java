package com.darke.covid19.service;

import com.darke.covid19.dto.request.PersonaRequestDto;
import com.darke.covid19.dto.response.PersonaResponseDto;
import com.darke.covid19.entity.Persona;
import com.darke.covid19.repository.IPersonaRepository;
import com.darke.covid19.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersonaService{
    //Dependency Injections
    IPersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void crearPersona(PersonaRequestDto personaRequestDto) {
        personaRepository.agregarPersona(personaRequestDto);
    }

    @Override
    public List<PersonaResponseDto> buscarPersonaRiesgo() {
        List<PersonaResponseDto> listaPersonasRiesgo = new ArrayList<>();
        List<Persona> listaPersonas = personaRepository.getPersonas();
        for (Persona persona : listaPersonas) {
            if(persona.getEdad() >= 60){
                listaPersonasRiesgo.add(new PersonaResponseDto(
                        persona.getId(),
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getEdad(),
                        persona.getSintomas()
                ));
            }
        }
        return listaPersonasRiesgo;
    }
}

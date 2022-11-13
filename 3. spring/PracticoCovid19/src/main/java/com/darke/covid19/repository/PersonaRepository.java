package com.darke.covid19.repository;

import com.darke.covid19.dto.request.PersonaRequestDto;
import com.darke.covid19.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository implements IPersonaRepository{
    List<Persona> listaPersonas = new ArrayList<>();
    int iterador=1;

    @Override
    public void agregarPersona(PersonaRequestDto personaRequestDto) {
        Persona persona = new Persona(iterador++,
                personaRequestDto.getNombre(),
                personaRequestDto.getApellido(),
                personaRequestDto.getEdad(),
                personaRequestDto.getSintomas());

        listaPersonas.add(persona);
    }

    @Override
    public List<Persona> getPersonas() {
        return listaPersonas;
    }
}

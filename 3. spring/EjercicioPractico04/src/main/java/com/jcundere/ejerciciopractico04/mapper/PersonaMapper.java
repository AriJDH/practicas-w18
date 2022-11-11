package com.jcundere.ejerciciopractico04.mapper;

import com.jcundere.ejerciciopractico04.DTO.request.PersonaRequest;
import com.jcundere.ejerciciopractico04.DTO.response.PersonaResponse;
import com.jcundere.ejerciciopractico04.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaMapper {

    public static List<PersonaResponse> personaList2PersonaResponseList(List<Persona> personaList) {

        List<PersonaResponse> personaResponseList = new ArrayList<>();

        for (Persona elemento : personaList) {
            personaResponseList.add(PersonaMapper.persona2PersonaResponse(elemento));
        }

        return personaResponseList;
    }

    public static PersonaResponse persona2PersonaResponse(Persona persona) {

        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setNombre(persona.getNombre());
        personaResponse.setApellido(persona.getApellido());
        personaResponse.setEdad(persona.getEdad());

        return personaResponse;
    }

    public static Persona personaResponse2Persona(PersonaResponse personaResponse) {

        Persona persona = new Persona();
        persona.setNombre(personaResponse.getNombre());
        persona.setApellido(personaResponse.getApellido());
        persona.setEdad(personaResponse.getEdad());

        return persona;
    }

    public static PersonaRequest persona2PersonaRequest(Persona persona) {

        PersonaRequest personaRequest = new PersonaRequest();
        personaRequest.setNombre(persona.getNombre());
        personaRequest.setApellido(persona.getApellido());
        personaRequest.setEdad(persona.getEdad());

        return personaRequest;
    }

    public static Persona personaRequest2Persona(PersonaRequest personaRequest) {

        Persona persona = new Persona();
        persona.setNombre(personaRequest.getNombre());
        persona.setApellido(personaRequest.getApellido());
        persona.setEdad(personaRequest.getEdad());

        return persona;
    }

}

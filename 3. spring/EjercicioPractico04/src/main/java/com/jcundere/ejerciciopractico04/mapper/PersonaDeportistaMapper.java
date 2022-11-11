package com.jcundere.ejerciciopractico04.mapper;

import com.jcundere.ejerciciopractico04.DTO.response.PersonaDeportistaResponse;
import com.jcundere.ejerciciopractico04.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaDeportistaMapper {

    public static List<PersonaDeportistaResponse> personaList2PersonaDeportistaList(List<Persona> perosnaList) {

        List<PersonaDeportistaResponse> personaDeportistaResponseList = new ArrayList<>();

        for (Persona elemento : perosnaList) {
            personaDeportistaResponseList.add(PersonaDeportistaMapper.persona2PersonaDeportistaResponse(elemento));
        }

        return personaDeportistaResponseList;
    }

    public static PersonaDeportistaResponse persona2PersonaDeportistaResponse(Persona persona) {

        PersonaDeportistaResponse personaDeportistaResponse = new PersonaDeportistaResponse();

        personaDeportistaResponse.setNombre(persona.getNombre());
        personaDeportistaResponse.setApellido(persona.getApellido());
        personaDeportistaResponse.setNombreDeporte(persona.getDeportesPracticados().get(0).getNombre());

        return personaDeportistaResponse;
    }
}

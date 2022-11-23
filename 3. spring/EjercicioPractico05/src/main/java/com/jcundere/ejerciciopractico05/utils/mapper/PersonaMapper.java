package com.jcundere.ejerciciopractico05.utils.mapper;

import com.jcundere.ejerciciopractico05.DTO.response.PersonaResponse;
import com.jcundere.ejerciciopractico05.entity.PersonaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonaMapper {

    public static PersonaResponse personaEntity2PersonaResponse(PersonaEntity personaEntity) {

        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setNombre(personaEntity.getNombre());
        personaResponse.setApellido(personaEntity.getApellido());
        personaResponse.setEdad(personaEntity.getEdad());

        return personaResponse;
    }

    public static List<PersonaResponse> personaEntityList2PersonaResponseList(List<PersonaEntity> personaEntityList) {

        List<PersonaResponse> personaResponseList = new ArrayList<>();

        for (PersonaEntity elemento : personaEntityList) {
            personaResponseList.add(personaEntity2PersonaResponse(elemento));
        }

        return personaResponseList;
    }

    public static PersonaResponse personaEntityWithRisk2PersonaResponseWithRisk(PersonaEntity personaEntity) {

        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setNombre(personaEntity.getNombre());
        personaResponse.setApellido(personaEntity.getApellido());
        personaResponse.setEdad(personaEntity.getEdad());
        personaResponse.setNombreSintomaList(personaEntity.getSintomaAsociadoList()
                .stream()
                .map(sintomaEntity -> sintomaEntity.getNombre())
                .collect(Collectors.toList()));

        return personaResponse;
    }

    public static List<PersonaResponse> personaEntityWithRiskList2PersonaResponseWithRiskList (List<PersonaEntity> personaEntityList) {

        List<PersonaResponse> personaResponseWithRiskList = new ArrayList<>();

        for (PersonaEntity elemento : personaEntityList) {
            personaResponseWithRiskList.add(personaEntityWithRisk2PersonaResponseWithRisk(elemento));
        }

        return personaResponseWithRiskList;
    }

}

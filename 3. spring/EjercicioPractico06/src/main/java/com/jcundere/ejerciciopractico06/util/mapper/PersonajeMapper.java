package com.jcundere.ejerciciopractico06.util.mapper;

import com.jcundere.ejerciciopractico06.dto.request.PersonajeRequest;
import com.jcundere.ejerciciopractico06.dto.response.PersonajeResponse;
import com.jcundere.ejerciciopractico06.entity.PersonajeEntity;

import java.util.ArrayList;
import java.util.List;

public class PersonajeMapper {

    public static PersonajeResponse entity2Response(PersonajeEntity personajeEntity) {

        PersonajeResponse personajeResponse = new PersonajeResponse();
        personajeResponse.setName(personajeEntity.getName());
        personajeResponse.setHeight(personajeEntity.getHeight());
        personajeResponse.setMass(personajeEntity.getMass());
        personajeResponse.setGender(personajeEntity.getGender());
        personajeResponse.setHomeworld(personajeEntity.getHomeworld());
        personajeResponse.setSpecies(personajeEntity.getSpecies());

        return personajeResponse;
    }

    public static List<PersonajeResponse> entityList2ResponseList(List<PersonajeEntity> personajeEntityList) {

        List<PersonajeResponse> personajeResponseList = new ArrayList<>();

        for (PersonajeEntity entity : personajeEntityList) {
            personajeResponseList.add(entity2Response(entity));
        }

        return personajeResponseList;
    }

    public static PersonajeEntity request2Entity(PersonajeRequest personajeRequest) {

        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setName(personajeRequest.getName());

        if (personajeRequest.getHeight().equals("NA")) {

            personajeEntity.setHeight(0);

        } else {

            personajeEntity.setHeight(Integer.valueOf(personajeRequest.getHeight()));
        }

        if (personajeRequest.getMass().equals("NA")) {

            personajeEntity.setMass(0);

        } else if (personajeRequest.getMass().contains(",")) {

            String fixDouble = personajeRequest.getMass().replace(",", ".");
            Double numInDouble = Double.valueOf(fixDouble);
            personajeEntity.setMass(numInDouble.intValue());

        } else if (personajeRequest.getMass().contains(".")) {

            Double numInDouble = Double.valueOf(personajeRequest.getMass());
            personajeEntity.setMass(numInDouble.intValue());

        } else {

            personajeEntity.setMass(Integer.valueOf(personajeRequest.getMass()));
        }

        personajeEntity.setHairColor(personajeRequest.getHairColor());
        personajeEntity.setSkinColor(personajeRequest.getSkinColor());
        personajeEntity.setEyeColor(personajeRequest.getEyeColor());
        personajeEntity.setBirthYear(personajeRequest.getBirthYear());
        personajeEntity.setGender(personajeRequest.getGender());
        personajeEntity.setHomeworld(personajeRequest.getHomeworld());
        personajeEntity.setSpecies(personajeRequest.getSpecies());

        return personajeEntity;
    }

    public static List<PersonajeEntity> requestList2EntityList(List<PersonajeRequest> personajeRequestList) {

        List<PersonajeEntity> personajeEntityList = new ArrayList<>();

        for (PersonajeRequest request : personajeRequestList) {
            personajeEntityList.add(request2Entity(request));
        }

        return personajeEntityList;
    }

}

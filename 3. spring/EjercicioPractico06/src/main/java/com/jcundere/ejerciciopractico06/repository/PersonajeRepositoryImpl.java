package com.jcundere.ejerciciopractico06.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcundere.ejerciciopractico06.dto.request.PersonajeRequest;
import com.jcundere.ejerciciopractico06.entity.PersonajeEntity;
import com.jcundere.ejerciciopractico06.util.mapper.PersonajeMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository<PersonajeEntity> {

    List<PersonajeEntity> personajeEntityList = loadList();

    @Override
    public void save(PersonajeEntity entity) {
        personajeEntityList.add(entity);
    }

    @Override
    public void saveAll(List<PersonajeEntity> objetoList) {
        personajeEntityList = objetoList;
    }

    @Override
    public List<PersonajeEntity> searchByName(String name) {

        List<PersonajeEntity> result = new ArrayList<>();

        for (PersonajeEntity elemento : personajeEntityList) {
            if (elemento.getName().contains(name)) {
                result.add(elemento);
            }
        }

        return result;
    }

    @Override
    public List getAll() {
        return personajeEntityList;
    }

    private List<PersonajeEntity> loadList() {

        List<PersonajeEntity> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;

        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");

            List<PersonajeRequest> personajeRequestList;
            personajeRequestList = mapper.readValue(jsonFile, new TypeReference<List<PersonajeRequest>>() {});
            list = PersonajeMapper.requestList2EntityList(personajeRequestList);

        } catch (Exception ex) {
            System.out.println("No existe el archivo. " + ex.getMessage());
        }

        return list;
    }

}

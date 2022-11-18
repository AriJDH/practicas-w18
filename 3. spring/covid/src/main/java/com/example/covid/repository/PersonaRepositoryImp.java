package com.example.covid.repository;

import com.example.covid.entity.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImp implements IPersonaRepository{
    List<Person> persons=new ArrayList<>();

    public PersonaRepositoryImp() {
        loadList();
    }

    @Override
    public List<Person> findRiskPerson() {
        List<Person> results= new ArrayList<>();
        for(Person person: persons){
            if(person.getAge() >= 60 && person.getSymptoms().size()>=1){
                results.add(person);
            }
        }
        return results;
    }

    private void loadList(){
        ObjectMapper mapper= new ObjectMapper();
        mapper.findAndRegisterModules();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:person.json");
            persons = mapper.readValue(jsonFile, new TypeReference<List<Person>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}

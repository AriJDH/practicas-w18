package com.example.covid.repository;

import com.example.covid.entity.Person;
import com.example.covid.entity.Symptom;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SymptomRepositoryImp implements ISymptomRepository{
    List<Person> persons = new ArrayList<>();

    public SymptomRepositoryImp() {
        loadList();
    }

    @Override
    public List<Symptom> findSymptom() {
        List<Symptom> symptoms = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            symptoms.addAll(persons.get(i).getSymptoms());
        }
        return symptoms;
        }



    @Override
    public Symptom findSymptom(String name) {
        List<Symptom> symptoms = findSymptom();
        return symptoms.stream().filter(symptom -> symptom.getName().equals(name)).findFirst().get();
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

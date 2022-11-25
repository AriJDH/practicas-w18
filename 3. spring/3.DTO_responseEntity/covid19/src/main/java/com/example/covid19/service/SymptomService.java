package com.example.covid19.service;

import com.example.covid19.model.Symptom;
import com.example.covid19.repository.ISymptomRepository;

import java.util.ArrayList;
import java.util.List;

public class SymptomService implements ISymptomRepository {
    List<Symptom> symptomList = new ArrayList<>();
    public SymptomService() {    }

    public void addSymptom(Symptom simptom){
        symptomList.add(simptom);
    }

    @Override
    public void findAllSymptoms() {
        symptomList.stream().map(Symptom::toString).forEach(System.out::println);
    }

    @Override
    public String showSeverityBySymptom(String symptomName) {
        //busca un symptom by name y print atributo severity
        if ( symptomName !=null){
            Symptom symptomFound = (Symptom) symptomList.stream().filter(s -> s.getName().equals(symptomName));
            return symptomFound.getSeverity_level();
        }else {
            return "not found";
        }
    }


}

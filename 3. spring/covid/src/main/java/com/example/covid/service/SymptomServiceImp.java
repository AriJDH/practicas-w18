package com.example.covid.service;

import com.example.covid.dto.PersonDTORes;
import com.example.covid.dto.SymptomDTORes;
import com.example.covid.entity.Person;
import com.example.covid.entity.Symptom;
import com.example.covid.repository.ISymptomRepository;
import com.example.covid.repository.SymptomRepositoryImp;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomServiceImp implements ISymptomService{
    private final ISymptomRepository symptomRepository;

    private final ObjectMapper mapper;

    public SymptomServiceImp(SymptomRepositoryImp symptomRepository, ObjectMapper mapper) {
        this.symptomRepository = symptomRepository;
        this.mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.findAndRegisterModules();
    }

    @Override
    public List<SymptomDTORes> findSymptom() {
        List<Symptom> symptoms = symptomRepository.findSymptom();
        return symptoms.stream().map(symtom -> mapper.convertValue(symtom, SymptomDTORes.class)).collect(Collectors.toList());
    }

    @Override
    public SymptomDTORes findSymptom(String name) {

        Symptom symptom = symptomRepository.findSymptom(name);
        SymptomDTORes symptomDTORes = mapper.convertValue(symptom,SymptomDTORes.class);
        return symptomDTORes;
    }
}

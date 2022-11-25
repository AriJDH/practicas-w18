package com.example.covid19.repository;

import com.example.covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISymptomRepository {
    void findAllSymptoms();
    String showSeverityBySymptom(String symptomName);



}

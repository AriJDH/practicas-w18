package com.example.covid.repository;

import com.example.covid.entity.Symptom;

import java.util.List;

public interface ISymptomRepository {
    List<Symptom> findSymptom();
    Symptom findSymptom(String name);
}

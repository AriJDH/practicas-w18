package com.example.covid.service;

import com.example.covid.dto.SymptomDTORes;
import com.example.covid.entity.Symptom;

import java.util.List;

public interface ISymptomService {
    List<SymptomDTORes> findSymptom();
    SymptomDTORes findSymptom(String name);
}

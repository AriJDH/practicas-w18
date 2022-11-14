package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.response.PersonaDtoResponse;
import com.bootcamp.covid19.dto.response.SintomaDtoResponse;
import com.bootcamp.covid19.entity.Persona;
import com.bootcamp.covid19.entity.Sintoma;

import java.util.List;

public interface ICovid19Service {
    List<SintomaDtoResponse> findSymptom();
    List<SintomaDtoResponse> findSymptomByName(String name);
    List<PersonaDtoResponse> findRiskPerson();

}

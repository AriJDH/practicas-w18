package com.example.covid19.service;

import com.example.covid19.dto.request.PersonaDTOrequest;
import com.example.covid19.dto.request.SintomaDTOrequest;

import java.util.List;

public interface IServer {
    List<SintomaDTOrequest> findSymptom();
    SintomaDTOrequest findSymptom(String name);
    List<PersonaDTOrequest> findRiskPerson();
}

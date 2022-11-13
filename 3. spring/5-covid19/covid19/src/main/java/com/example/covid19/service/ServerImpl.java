package com.example.covid19.service;

import com.example.covid19.dto.request.PersonaDTOrequest;
import com.example.covid19.dto.request.SintomaDTOrequest;
import com.example.covid19.entity.Persona;
import com.example.covid19.entity.Sintoma;
import com.example.covid19.repository.IRepository;
import com.example.covid19.repository.RepositoryImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServerImpl implements IServer{
    IRepository iRepository = new RepositoryImpl();

    @Override
    public List<SintomaDTOrequest> findSymptom() {
        ObjectMapper objectMapper = new ObjectMapper();
        //para no tener problemas si en el DTO tengo menos atributos que en la entidad
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //Trae datos necesarios
        List<Sintoma> sintomas = iRepository.findSymptom();
        //mappeo
        List<SintomaDTOrequest> sintomaDTOrequests = sintomas.stream()
                .map(sintoma -> objectMapper.convertValue(sintoma,SintomaDTOrequest.class)).collect(Collectors.toList());
        return sintomaDTOrequests;

    }

    @Override
    public SintomaDTOrequest findSymptom(String name) {
        ObjectMapper objectMapper = new ObjectMapper();


        //Trae datos necesarios
        Sintoma sintomas = iRepository.findSymtom(name);
        //mappeo
        SintomaDTOrequest sintomaDTOrequests = objectMapper.convertValue(sintomas,SintomaDTOrequest.class);
        return sintomaDTOrequests;
    }

    @Override
    public List<PersonaDTOrequest> findRiskPerson() {
        ObjectMapper objectMapper = new ObjectMapper();
        //para no tener problemas si en el DTO tengo menos atributos que en la entidad
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Persona> personas = iRepository.findRiskPerson();
        List<PersonaDTOrequest> personaDTOrequestList = personas.stream().map(persona -> objectMapper.convertValue(persona,PersonaDTOrequest.class)).collect(Collectors.toList());
        return personaDTOrequestList;
    }
}

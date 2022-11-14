package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.response.PersonaDtoResponse;
import com.bootcamp.covid19.dto.response.SintomaDtoResponse;
import com.bootcamp.covid19.entity.Persona;
import com.bootcamp.covid19.entity.Sintoma;
import com.bootcamp.covid19.repository.Covid19Repository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class Covid19Service implements  ICovid19Service{
    Covid19Repository covid19Repository = new Covid19Repository();
    List<Sintoma> sintomas = covid19Repository.listaSintomas();
    List<Persona> personas = covid19Repository.listaPersona();

    @Override
    public List<SintomaDtoResponse> findSymptom() {
        List<SintomaDtoResponse> sintomaList = sintomas.stream()
                .map(p-> SintomaDtoResponse.builder()
                        .nombre(p.getNombre()).build())
                .collect(Collectors.toList());
        return sintomaList;
    }

    @Override
    public List<SintomaDtoResponse> findSymptomByName(String name) {
        List<SintomaDtoResponse> sintomaDtoResponseLis = sintomas.stream()
                .filter(p-> p.getNombre().equals(name))
                .map(p -> SintomaDtoResponse.builder()
                        .nivel_de_gravedad(p.getNivel_de_gravedad()).build())
                .collect(Collectors.toList());
        return sintomaDtoResponseLis;
    }

    @Override
    public List<PersonaDtoResponse> findRiskPerson() {
        List<PersonaDtoResponse> personaDtoResponseList = personas.stream()
                .filter(p -> p.getEdad() > 60)
                .map(p -> PersonaDtoResponse.builder().nombre(p.getNombre()).apellido(p.getApellido()).sintomasPersona(p.getSintomasPersona()).build())
                .collect(Collectors.toList());
        return personaDtoResponseList;
    }
}

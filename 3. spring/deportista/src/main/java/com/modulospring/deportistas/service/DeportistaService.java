package com.modulospring.deportistas.service;


import com.modulospring.deportistas.dto.response.DeporteDtoResponse;
import com.modulospring.deportistas.dto.response.PersonaDtoResponse;
import com.modulospring.deportistas.entity.Deporte;
import com.modulospring.deportistas.entity.Persona;
import com.modulospring.deportistas.repositorio.Repositorio;

import java.util.List;
import java.util.stream.Collectors;

public class DeportistaService implements IDeportistaService {
    Repositorio repositorio = new Repositorio();
    List<Deporte> deporteList = repositorio.addListSport();
    List<Persona> personaList = repositorio.addListPerson();

    @Override
    public List<DeporteDtoResponse> findSports() {
        List<DeporteDtoResponse> dtoList = deporteList.stream()
                .map(p -> DeporteDtoResponse.builder().nombre(p.getNombre()).build())
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public List<DeporteDtoResponse> findSportByName(String name) {
//       List<DeporteNivelDtoResponse> deporteDtos = deporteList.stream().filter(p-> p.getNombre().equals(name)).map(p-> new DeporteNivelDtoResponse(p.getNivel())).collect(Collectors.toList());
        List<DeporteDtoResponse> deporteDtos = deporteList.stream()
                .filter(p -> p.getNombre().equals(name))
                .map(p -> DeporteDtoResponse.builder()
                        .nivel(p.getNivel()).build())
                .collect(Collectors.toList());
        return deporteDtos;
    }

    @Override
    public List<PersonaDtoResponse> findSportsPersons() {
        List<PersonaDtoResponse> personaDtoResponseList = personaList.stream()
                .map(p ->  PersonaDtoResponse.builder().nombre(p.getNombre()).apellido(p.getApellido()).deporteDtoRequestList(p.getDeporteList()).build())
                .collect(Collectors.toList());
        return personaDtoResponseList;
    }
}

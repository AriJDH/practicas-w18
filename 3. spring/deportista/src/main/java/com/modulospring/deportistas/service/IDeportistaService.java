package com.modulospring.deportistas.service;

import com.modulospring.deportistas.dto.response.DeporteDtoResponse;
import com.modulospring.deportistas.dto.response.PersonaDtoResponse;

import java.util.List;

public interface IDeportistaService{
    List<DeporteDtoResponse> findSports ();
    List<DeporteDtoResponse> findSportByName(String name);
    List<PersonaDtoResponse> findSportsPersons();

}

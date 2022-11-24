package com.jcundere.ejerciciopractico06.service;

import com.jcundere.ejerciciopractico06.dto.request.PersonajeRequest;
import com.jcundere.ejerciciopractico06.dto.response.PersonajeResponse;

import java.util.List;

public interface IPersonajeService {

    List<PersonajeResponse> searchPersonajeListByName(String name);

}

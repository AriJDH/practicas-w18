package com.example.StarsWars.service;

import com.example.StarsWars.dto.response.PersonajeDtoRes;
import com.example.StarsWars.entity.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonajeService {
    List<PersonajeDtoRes> getPersonajesServ(String palabra);
}

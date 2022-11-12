package com.example.StarsWars.service;

import com.example.StarsWars.dto.response.PersonajeDtoRes;
import com.example.StarsWars.entity.Personaje;
import com.example.StarsWars.repository.IPersonajeRepository;
import com.example.StarsWars.repository.PerosnajeRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements IPersonajeService {

    //Creo una instancia para poder acceder al repository.
    IPersonajeRepository personajeRepository = new PerosnajeRepositoryImp();

    @Override
    public List<PersonajeDtoRes> getPersonajesServ(String palabra) {
        List<Personaje> listOfPersonaje = personajeRepository.finAllPeronajes();

        List<PersonajeDtoRes> personajeDtoResList = listOfPersonaje.stream()
                .map(personaje -> new PersonajeDtoRes(personaje))
                .collect(Collectors.toList());

        //Envio la lista Dto al controllador.
        return personajeDtoResList;
    }
}

package com.starwars.starwars.service;

import com.starwars.starwars.dto.PersonajeDto;
import com.starwars.starwars.entity.Personaje;
import com.starwars.starwars.repository.IperonsaRepository;
import com.starwars.starwars.repository.PersonaRepositoryImp;
import org.springframework.boot.autoconfigure.influx.InfluxDbOkHttpClientBuilderProvider;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeServiceImp implements IpersonajeService{

    private IperonsaRepository personajeRepository =  new PersonaRepositoryImp();


    @Override
    public PersonajeDto findByName(String name) {
        PersonajeDto pDto = null;
        for(Personaje p: personajeRepository.getAll()){
            if(p.getName().contains(name))
                pDto=new PersonajeDto(p.getName(),p.getHeight(),p.getMass(),p.getGender(),p.getHomeworld(),p.getSpecies());
        }

        return pDto;
    }


}

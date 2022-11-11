package com.example.starwarsjson;

import com.example.starwarsjson.entities.Personaje;
import com.example.starwarsjson.repositories.PersonajeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDBConfig {

    @Bean(name = "cargaInicialDb")
    public CommandLineRunner loadDb(PersonajeRepository personajeRepository){
        return (args)->{
        };
    }
}

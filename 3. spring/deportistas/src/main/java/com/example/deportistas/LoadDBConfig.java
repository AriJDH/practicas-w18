package com.example.deportistas;

import com.example.deportistas.domain.Deporte;
import com.example.deportistas.domain.NivelDeporte;
import com.example.deportistas.domain.Persona;
import com.example.deportistas.repositories.DeporteRepository;
import com.example.deportistas.repositories.PersonaRepository;
import com.example.deportistas.repositories.RepositoryFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDBConfig {
    private PersonaRepository personaRepository = RepositoryFactory.getPersonaRepository();
    private DeporteRepository deporteRepository = RepositoryFactory.getDeporteRepository();
    @Bean(name = "cargaInicialDb")
    public CommandLineRunner loadDb(){
        return (args)->{
            Deporte futbol = new Deporte("futbol", NivelDeporte.MEDIO);
            Deporte basquet = new Deporte("basquet", NivelDeporte.MEDIO);
            deporteRepository.add(futbol);
            deporteRepository.add(basquet);
            Persona marcos = new Persona("Marcos", "Infantino", 22, basquet);
            personaRepository.add(marcos);

        };
    }
}

package com.example.covid;

import com.example.covid.domain.NivelDeGravedad;
import com.example.covid.domain.Persona;
import com.example.covid.domain.Sintoma;
import com.example.covid.domain.dtos.PersonaDTO;
import com.example.covid.repositories.PersonaRepository;
import com.example.covid.repositories.RepositoryFactory;
import com.example.covid.repositories.SintomaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDBConfig {
    private PersonaRepository personaRepository = RepositoryFactory.getPersonaRepository();
    private SintomaRepository sintomaRepository = RepositoryFactory.getSintomaRepository();
    @Bean(name = "cargaInicialDb")
    public CommandLineRunner loadDb(){
        return (args)->{

            Sintoma fiebre = new Sintoma(1, "fiebre", NivelDeGravedad.GRAVE);
            Sintoma tos = new Sintoma(2, "tos", NivelDeGravedad.MEDIO);
            Sintoma frio = new Sintoma(3, "frio", NivelDeGravedad.LEVE);
            sintomaRepository.add(fiebre);
            sintomaRepository.add(tos);
            sintomaRepository.add(frio);

            Persona marcos = new Persona(1,"Marcos", "Infantino", 22);
            marcos.addSintoma(frio);
            Persona abuelo = new Persona(2,"Norberto", "Rodriguez", 70);
            abuelo.addSintoma(fiebre);
            abuelo.addSintoma(tos);

            personaRepository.add(marcos);
            personaRepository.add(abuelo);
        };
    }
}

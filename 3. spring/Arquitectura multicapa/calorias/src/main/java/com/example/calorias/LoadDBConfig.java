package com.example.calorias;
import com.example.calorias.repositories.IngredienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDBConfig {
    @Bean(name = "cargaInicialDb")
    public CommandLineRunner loadDb(IngredienteRepository ingredienteRepository){
        return (args)->{

        };
    }
}

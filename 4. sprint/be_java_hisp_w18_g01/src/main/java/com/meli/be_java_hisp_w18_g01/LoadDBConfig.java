package com.meli.be_java_hisp_w18_g01;

import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDBConfig {

    @Autowired
    private UserRepository userRepository;
    @Bean(name = "cargaInicialDb")
    public CommandLineRunner loadDb(){
        return (args)->{

            User user = new User();
            //userRepository.add(user); y asi vamos agregando datos mock a la db en memoria

        };
    }
}

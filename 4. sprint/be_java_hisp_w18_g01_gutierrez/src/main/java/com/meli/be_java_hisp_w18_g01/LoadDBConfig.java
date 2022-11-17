package com.meli.be_java_hisp_w18_g01;

import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class LoadDBConfig {

    @Autowired
    private UserRepository userRepository;
    @Bean(name = "cargaInicialDb")
    public CommandLineRunner loadDb(){
        return (args)->{

            User lucas = new User(1L, "lucas");
            userRepository.add(lucas);

            User miguel = new User(2L, "miguel");
            userRepository.add(miguel);

            User laura = new User(3L, "laura");
            userRepository.add(laura);

        };
    }
}

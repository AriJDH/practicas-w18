package com.profiles.profiles.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class DevConfig {

    @PostConstruct
    public void initialize(){
        System.out.println("--- Perfil activo DEV ----");
    }

}

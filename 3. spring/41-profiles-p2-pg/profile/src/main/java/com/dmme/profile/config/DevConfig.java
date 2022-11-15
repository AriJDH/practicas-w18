package com.dmme.profile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class DevConfig {
    @PostConstruct // Se ejecuta al inicializar la aplicacion (solo si estamos en "dev")
    public void initialize() {
        System.out.println("--------Iniciando el ambiente DEV-------");
    }
}

package com.example.calculadoracalorias.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

}

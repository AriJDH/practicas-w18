package com.meli.obtenerdiploma.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
	
	// Creamos un Bean para instanciar un <<mapper>> en el contexto
	@Bean(name = "mapp")
	public ObjectMapper objectMapper() {
		return new ObjectMapper(); // Retornamos un objeto ObjectMapper para Spring
	}
	
}

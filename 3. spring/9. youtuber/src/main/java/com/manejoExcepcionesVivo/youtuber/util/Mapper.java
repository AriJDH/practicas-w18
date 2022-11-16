package com.manejoExcepcionesVivo.youtuber.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Indicamos que la clase será de tipo configuración
public class Mapper {
	
	// Creamos un Bean para instanciar un <<mapper>> en el contexto
	@Bean(name = "mapp")
	public ObjectMapper objectMapper(){
		return new ObjectMapper(); // Retornamos un objeto ObjectMapper para Spring
	}
	
}

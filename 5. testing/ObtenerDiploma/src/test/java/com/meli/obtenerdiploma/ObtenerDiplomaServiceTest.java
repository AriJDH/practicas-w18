package com.meli.obtenerdiploma;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;

@SpringBootTest
public class ObtenerDiplomaServiceTest  {
    
    
    @Test
	public void contextLoads() {

        IObtenerDiplomaService obtenerDiplomaService = new ObtenerDiplomaService();

	}
}

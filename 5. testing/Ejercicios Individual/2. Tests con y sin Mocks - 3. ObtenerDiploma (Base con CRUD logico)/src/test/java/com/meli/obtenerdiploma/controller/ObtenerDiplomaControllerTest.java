package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObtenerDiplomaControllerTest {
	
	@Mock
	IObtenerDiplomaService obtenerDiplomaService;
	
	@InjectMocks
	ObtenerDiplomaController obtenerDiplomaController;
	
	@Test
	@DisplayName("US0012 - Analizar puntaje happy path =^.^=")
	void analyzeScoresOkTest() {
		
		// MOCKS
		obtenerDiplomaController.analyzeScores(1L);
		verify(obtenerDiplomaService).analyzeScores(1L);
	}
}
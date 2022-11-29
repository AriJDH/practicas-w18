package com.meli.obtenerdiploma.unit.units;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.meli.obtenerdiploma.unit.utils.ListSubjectDTOFactory.*;
import static com.meli.obtenerdiploma.unit.utils.StudentDTOFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTests {

	@Mock
	IStudentDAO studentDAO;

	@InjectMocks
	ObtenerDiplomaService service;


	@Test
	@DisplayName("Análisis de score promedio 8 - Camino Feliz :D")
	public void analyzeScores() {
		// Arrange
		Long query = 2L;
		StudentDTO studentDTO = utilNewStudentDto(query, "Pedro", utilNewListSubjectDtoAvg8());
		Double avgExpected = 8D;
		// Mock
		when(studentDAO.findById(query)).thenReturn(studentDTO);
		// Act
		StudentDTO result = service.analyzeScores(query);
		// Asserts
		assertEquals(avgExpected, result.getAverageScore());
	}


}
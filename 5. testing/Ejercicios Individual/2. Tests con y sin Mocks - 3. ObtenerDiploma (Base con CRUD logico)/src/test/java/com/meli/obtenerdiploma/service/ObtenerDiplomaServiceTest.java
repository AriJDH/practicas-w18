package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObtenerDiplomaServiceTest {
	
	// Lo que simulo:
	@Mock
	IStudentDAO studentDAO;
	
	// Para inyectarlo en:
	@InjectMocks
	ObtenerDiplomaService obtenerDiplomaService;
	
	@Test
	@DisplayName("US0007 - Calcular promedio happy path =^.^=")
	void analyzeScoresOkTest() {
		
		// ARRANGE / Creamos nuestro propio estudiante completo
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe Mock");
		studentDTO.setMessage("Message Ok Mock");
		studentDTO.setSubjects(subjectDTOList);
		
		// MOCKS / Cuando llamos al método del DAO nos retorna nuestro estudiante simulando la respuesta
		when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
		
		// ACT / Ejecutamos el método del service
		StudentDTO studentDTOReal = obtenerDiplomaService.analyzeScores(studentDTO.getId());
		
		// ASSERTS
		assertAll("Datos de salida correctos",
		          // Promedio
		          () -> assertEquals(10.0, studentDTOReal.getAverageScore()),
		          // Mensaje del diploma
		          () -> assertEquals("El alumno Pepe Mock ha obtenido un promedio de 10. Felicitaciones!",
		                             studentDTOReal.getMessage()),
		          // Coincide nombre
		          () -> assertEquals(studentDTO.getStudentName(), studentDTOReal.getStudentName()));
	}
	
	@Test
	@DisplayName("US0008 - Calcular promedio null T.T")
	void analyzeScoresNotOkTest() {
		
		// ARRANGE
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO());
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe Mock");
		studentDTO.setMessage("Message Ok Mock");
		studentDTO.setSubjects(subjectDTOList);
		
		// MOCKS
		when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
		
		// ASSERTS
		assertThrows(RuntimeException.class, () -> obtenerDiplomaService.analyzeScores(studentDTO.getId()));
	}
	
}
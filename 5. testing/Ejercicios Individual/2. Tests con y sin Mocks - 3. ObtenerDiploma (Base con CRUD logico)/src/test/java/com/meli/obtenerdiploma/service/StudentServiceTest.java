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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentServiceTest {
	
	// Simulamos el DAO
	@Mock
	IStudentDAO studentDAO;
	
	// Lo inyectamos en el service
	@InjectMocks
	StudentService studentService;
	
	@Test
	@DisplayName("US0009 - Crear un nuevo estudiante happy path")
	void create() {
		
		// ARRANGE / Creamos nuestro estudiante simulado
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe Mock");
		studentDTO.setMessage("Message Ok Mock");
		studentDTO.setSubjects(subjectDTOList);
		
		// MOCKS - ACT
		// Cuando llamamos a nuestro método crear del Service...
		studentService.create(studentDTO);
		// Verificamos con Mockito si pasó por el save del DAO
		verify(studentDAO).save(any(StudentDTO.class));
	}
	
	@Test
	@DisplayName("US0009 - Buscar un estudiante happy path")
	void read() {
		
		// ARRANGE / Creamos nuestro estudiante simulado
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe Mock");
		studentDTO.setMessage("Message Ok Mock");
		studentDTO.setSubjects(subjectDTOList);
		
		// MOCKS - ACT
		// Cuando llamamos a nuestro método buscar por ID del Service...
		studentService.read(studentDTO.getId());
		// Verificamos con Mockito si pasó por el findById del DAO
		verify(studentDAO).findById(any(Long.class));
	}
	
	@Test
	@DisplayName("US0009 - Modificar un estudiante happy path")
	void update() {
		
		// ARRANGE / Creamos nuestro estudiante simulado
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe Mock");
		studentDTO.setMessage("Message Ok Mock");
		studentDTO.setSubjects(subjectDTOList);
		
		// MOCKS
		verify(studentDAO).delete(studentDTO.getId()); // Chequea que se elimine
		verify(studentDAO).save(studentDTO); // Chequea que se vuelva a agregar
		
	}
	
	@Test
	@DisplayName("US0009 - Eliminar un estudiante happy path")
	void delete() {
	}
	
	@Test
	@DisplayName("US0009 - Buscar todos los estudiantes happy path")
	void getAll() {
	}
}
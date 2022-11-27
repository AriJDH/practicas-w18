package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
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
class StudentControllerTest {
	
	@Mock
	IStudentService studentService;
	
	@InjectMocks
	StudentController studentController;

	@Test
	@DisplayName("US0013 - Crear estudiante happy path =^.^=")
	void registerStudentOkTest() {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe");
		
		studentController.registerStudent(studentDTO);
		verify(studentService).create(studentDTO);
	}
	
	@Test
	@DisplayName("US0014 - Buscar estudiante happy path =^.^=")
	void getStudentOkTest() {
		
		studentController.getStudent(1L);
		verify(studentService).read(1L);
	}
	
	@Test
	@DisplayName("US0015 - Modificar estudiante happy path =^.^=")
	void modifyStudentOkTest() {
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe");
		
		studentController.modifyStudent(studentDTO);
		verify(studentService).update(studentDTO);
		
	}
	
	@Test
	@DisplayName("US0016 - Eliminar estudiante happy path =^.^=")
	void removeStudentOkTest() {
		
		studentController.removeStudent(1L);
		verify(studentService).delete(1L);
		
	}
	
	@Test
	@DisplayName("US0017 - Buscar todos los estudiantes happy path =^.^=")
	void listStudentsOkTest() {
		
		studentController.listStudents();
		verify(studentService).getAll();
	}
}
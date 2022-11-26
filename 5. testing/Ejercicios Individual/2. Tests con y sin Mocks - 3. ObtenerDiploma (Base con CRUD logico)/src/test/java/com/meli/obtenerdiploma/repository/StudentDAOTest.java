package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.HashSet;
import java.util.List;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {
	
	@Autowired private StudentDAO studentDAO;
	
	private StudentDTO studentDTO1;
	private StudentDTO studentDTO2;
	
	
	// Para testear con validator
	private static Validator validator;
	
	@BeforeAll
	static void beforeAll() {
		// Usamos try-with-resources porque el Validator requiere una cláusula close() al final
		try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
			validator = validatorFactory.getValidator();
		}
	}
	
	// Para preparar cada test individual
	@BeforeEach
	void setUp() {
		
		// ARRANGE / Objetos
		SubjectDTO subjectDTO1 = new SubjectDTO();
		subjectDTO1.setScore(9.0);
		subjectDTO1.setName("Maths");
		
		SubjectDTO subjectDTO2 = new SubjectDTO();
		subjectDTO1.setScore(8.0);
		subjectDTO1.setName("Art");
		
		studentDTO1 = new StudentDTO();
		studentDTO1.setId(1L);
		studentDTO1.setStudentName("Pepe");
		studentDTO1.setMessage("Message ok");
		studentDTO1.setAverageScore(8.0);
		studentDTO1.setSubjects(List.of(subjectDTO1, subjectDTO2));
		
		studentDTO2 = new StudentDTO();
		studentDTO2.setId(2L);
		studentDTO2.setStudentName("Pepe 2");
		studentDTO2.setMessage("Message Ok 2");
		studentDTO2.setAverageScore(8.0);
		studentDTO2.setSubjects(List.of(subjectDTO1, subjectDTO2));
	}
	
	@AfterEach
	void setUpAfter() {
		// Seteamos nuestra lista de prueba después de cada test
		studentDAO.setStudents(new HashSet<>());
	}
	
	@Test
	@DisplayName("US0001 - Agregar un alumno happy path =^.^=")
	void saveOkTest() {
		
		// ACT
		studentDAO.save(studentDTO1);
		StudentDTO result = studentDAO.findById(studentDTO1.getId());
		
		// ASSERT
		assertEquals(studentDTO1, result);
	}
	
	@Test
	@DisplayName("US0001 - Agregar un alumno nulo T.T")
	void saveNotOkNullTest() {
		
		// ARRANGE
		studentDTO1 = null;
		String expectedSimpleNameException = "NullPointerException";
		
		// ACT
		Exception exception = assertThrows(NullPointerException.class, () -> {
			studentDAO.save(studentDTO1);
		});
		
		String simpleNameExceptionResult = exception.getClass().getSimpleName();
		
		// ASSERTS
		assertEquals(expectedSimpleNameException, simpleNameExceptionResult);
		
	}
	
	@Test
	@DisplayName("US0001 - Agregar un alumno con campos vacíos T.T")
	void saveNotOkEmptyTest() {
		
		// ARRANGE
		studentDTO1 = new StudentDTO();
		
		// ACT
		Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO1);
		
		// ASSERTS
		assertFalse(violations.isEmpty());
	}
	
	@Test
	@DisplayName("US0001 - Agregar un alumno con al menos un campo inválido T.T")
	void saveNotOkInvalidTest() {
		
		// ARRANGE
		studentDTO1.setStudentName("pepe");
		
		// ACT
		Set<ConstraintViolation<StudentDTO>> violations = validator.validate(studentDTO1);
		
		// ASSERTS
		assertTrue(violations.size() > 0);
		
	}
	
	@Test
	@DisplayName("US0002 - Eliminar un alumno happy path =^.^=")
	void deleteOkTest() {
		
		// Agrego un alumno
		studentDAO.save(studentDTO1);
		// Lo muestro
		studentDAO.findById(1L);
		// Lo elimino
		studentDAO.delete(1L);
		// Lo vuelvo a buscar para ver si se eliminó
		Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
	}
	
	@Test
	@DisplayName("US0002 - Eliminar un alumno inexistente T.T")
	void deleteNotOkTest() {
		
		// ACT
		boolean studentDeleteResult = studentDAO.delete(100L);
		
		// ASSERTS
		assertFalse(studentDeleteResult);
	}
	
	@Test
	@DisplayName("US0003 - Buscar un alumno happy path =^.^=")
	void findByIdOkTest() {
		
		// ACT
		studentDAO.save(studentDTO1);
		StudentDTO studentDTOReal = studentDAO.findById(studentDTO1.getId());
		
		// ASSERTS
		assertEquals(studentDTO1, studentDTOReal);
	}
	
	@Test
	@DisplayName("US0004 - Buscar un alumno inexistente - Not Found Exception T.T")
	void findByIdNotOkTest() {
		
		Assertions.assertThrows(StudentNotFoundException.class, () -> {
			studentDAO.findById(200L);
		});
		
	}
	
	// Modificar estudiante -> no está desarrollado el método para poder testearlo
	
	@Test
	@DisplayName("US0005 - Buscar todos los alumnos - Happy path =^.^=")
	void findAllOkTest() {
		
		// ARRANGE
		studentDAO.save(studentDTO1);
		studentDAO.save(studentDTO2);
		
		// ACT
		Set<StudentDTO> studentDTOListReal = studentDAO.findAll();
		
		// ASSERTS
		assertEquals(2, studentDTOListReal.size());
		
	}
	
}
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
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {
	
	@Autowired
	private IStudentDAO studentDAO;
	
	private StudentDTO studentDTO1;
	private SubjectDTO subjectDTO1;
	private SubjectDTO subjectDTO2;
	
	// Para testear con validator
	private static Validator validator;
	
	@BeforeAll
	static void beforeAll() {
		// Usamos try-with-resources porque el Validator requiere una cláusula close() al final
		try (ValidatorFactory validatorFactory = Validation
						.buildDefaultValidatorFactory()) {
			validator = validatorFactory.getValidator();
		}
	}
	
	// Para preparar cada test individual
	@BeforeEach
	void setUp() {
		// ARRANGE / Objetos
		subjectDTO1 = new SubjectDTO();
		subjectDTO1.setScore(9.0);
		subjectDTO1.setName("Maths");
		
		subjectDTO2 = new SubjectDTO();
		subjectDTO1.setScore(8.0);
		subjectDTO1.setName("Art");
		
		
		studentDTO1 = new StudentDTO();
		studentDTO1.setId(1L);
		studentDTO1.setStudentName("Pepe");
		studentDTO1.setMessage("Message ok");
		studentDTO1.setAverageScore(8.0);
		studentDTO1.setSubjects(List.of(subjectDTO1, subjectDTO2));
	}
	
	@AfterEach
	void afterEach() {
		studentDTO1 = null;
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
		Optional<ConstraintViolation<StudentDTO>> first = violations
						.stream()
						.findFirst();
		assertAll(String.valueOf(first),
						() -> assertTrue(first.isPresent()),
						() -> assertEquals("El nombre del estudiante debe comenzar con mayúscula.",
										first.get().getMessage())
		);
		
	}
	
	@Test
	@DisplayName("US0002 - Eliminar un alumno happy path =^.^=")
	void deleteOkTest() {
		
		// ACT
		// Agrego un nuevo estudiante
		studentDAO.save(studentDTO1);
		// Verifico si existe ese estudiante
		studentDAO.findById(studentDTO1.getId());
		// Elimino ese estudiante
		studentDAO.delete(1L);
		// Lo vuelvo a buscar para ver si se eliminó
		
		
		// ASSERTS
		Assertions.assertThrows(StudentNotFoundException.class,
						() -> studentDAO.findById(1L));
	}
	
	// TODO terminar tests unitarios en DAO y evaluar casos <<bordes>>
	@Test
	@DisplayName("US0002 - Eliminar un alumno null/vacío/inválido T.T")
	void deleteNotOkTest() {
	}
	
	@Test
	@DisplayName("US0003 - Buscar un alumno happy path =^.^=")
	void findByIdOkTest() {
	}
	
	@Test
	@DisplayName("US0004 - Buscar un alumno null/vacío/inválido T.T")
	void findByIdNotOkTest() {
	}
	
	@Test
	@DisplayName("US0006 - Modificar alumno happy path =^.^= ")
	void updateOkTest() {
	
	}
	
}
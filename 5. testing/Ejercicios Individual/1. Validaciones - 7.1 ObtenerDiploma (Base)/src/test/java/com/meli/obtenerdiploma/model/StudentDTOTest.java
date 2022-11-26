package com.meli.obtenerdiploma.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentDTOTest {
	
	private static Validator validator;
	
	@BeforeAll
	static void beforeAll() {
		try (ValidatorFactory validatorFactory = Validation
						.buildDefaultValidatorFactory()) {
			validator = validatorFactory.getValidator();
		}
	}
	
	@Test
	@DisplayName("Primer letra en mayuscula :D")
	void primerLetraMayuscOKTest() {
		
		// Arrange
		SubjectDTO subjectDTO1 = new SubjectDTO();
		subjectDTO1.setName("Maths");
		subjectDTO1.setScore(9.0);
		
		SubjectDTO subjectDTO2 = new SubjectDTO();
		subjectDTO2.setName("Statistics");
		subjectDTO2.setScore(9.4);
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("Pepe");
		studentDTO.setMessage("Bienvenido");
		studentDTO.setAverageScore(9.2);
		studentDTO.setSubjects(List.of(subjectDTO1, subjectDTO2));
		
		// Act
		Set<ConstraintViolation<StudentDTO>> validate = validator.validate(studentDTO);
		
		// Asserts
		assertEquals(0, validate.size());
	}
	
	@Test
	@DisplayName("Primer letra del nombre en minusculas ")
	void primerLetraMayuscErrorTest() {
		
		// Arrange
		SubjectDTO subjectMaths = new SubjectDTO();
		subjectMaths.setName("Maths");
		subjectMaths.setScore(9.0);
		
		SubjectDTO subjectStats = new SubjectDTO();
		subjectStats.setName("Statistics");
		subjectStats.setScore(9.4);
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("pepe");
		studentDTO.setMessage("Bienvenido");
		studentDTO.setAverageScore(9.2);
		studentDTO.setSubjects(List.of(subjectMaths, subjectStats));
		
		// Act
		Set<ConstraintViolation<StudentDTO>> validate = validator.validate(studentDTO);
		
		// Asserts
		assertEquals(1, validate.size());
		Optional<ConstraintViolation<StudentDTO>> first = validate
						.stream()
						.findFirst();
		assertTrue(first.isPresent()); // Que el elemento exista
		assertEquals(
						"El nombre del alumno debe empezar con mayúscula",
						first.get().getMessage());
	}
	
	@Test
	@DisplayName("Primer letra de la materia en minusculas ")
	void primerLetraSubjectTest() {
		
		// Arrange
		SubjectDTO subjectMaths = new SubjectDTO();
		subjectMaths.setName("maths");
		subjectMaths.setScore(9.0);
		
		SubjectDTO subjectStats = new SubjectDTO();
		subjectStats.setName("Statistics");
		subjectStats.setScore(9.4);
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("Pepe");
		studentDTO.setMessage("Bienvenido");
		studentDTO.setAverageScore(9.2);
		studentDTO.setSubjects(List.of(subjectMaths, subjectStats));
		
		// Act
		Set<ConstraintViolation<StudentDTO>> validate = validator.validate(studentDTO);
		
		// Asserts
		assertEquals(1, validate.size());
		Optional<ConstraintViolation<StudentDTO>> first = validate
						.stream()
						.findFirst();
		assertTrue(first.isPresent()); // Que el elemento exista
		assertEquals(
						"El nombre de la materia debe empezar con mayúscula",
						first.get().getMessage());
	}
	
	@Test
	@DisplayName("Campo vacío en la materia")
	void campoVacioSubjectTest() {
		
		// Arrange
		SubjectDTO subjectMaths = new SubjectDTO();
		subjectMaths.setName("");
		subjectMaths.setScore(9.0);
		
		SubjectDTO subjectStats = new SubjectDTO();
		subjectStats.setName("Statistics");
		subjectStats.setScore(9.4);
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName("Pepe");
		studentDTO.setMessage("Bienvenido");
		studentDTO.setAverageScore(9.2);
		studentDTO.setSubjects(List.of(subjectMaths, subjectStats));
		
		// Act
		Set<ConstraintViolation<StudentDTO>> validate = validator.validate(studentDTO);
		
		// Asserts
		validate.stream()
						.forEach(v ->
										assertTrue(v.getMessage() != null));
		
	}
	
}
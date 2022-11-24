package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudent() {
        //ARRANGE
        Long id = 45545L;
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);
        StudentDTO student = new StudentDTO(id, "Student", "Student", 6.6, Arrays.asList(materia));

        //ACT
        studentController.registerStudent(student);

        //ASSERT
        verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    void getStudent() {
        //ARRANGE
        Long id = 45545L;
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);
        StudentDTO student = new StudentDTO(id, "Student", "Student", 6.6, Arrays.asList(materia));

        when(studentService.read(id)).thenReturn(student);

        //ACT
        StudentDTO studentResult = studentService.read(id);

        //ASSERT
        verify(studentService, atLeastOnce()).read(id);
        assertEquals(student, studentResult);
    }

    @Test
    void modifyStudent() {
        //ARRANGE
        Long id = 45545L;
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);
        StudentDTO student = new StudentDTO(id, "Student", "Student", 6.6, Arrays.asList(materia));

        //ACT
        studentController.modifyStudent(student);

        //ASSERT
       verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    void removeStudent() {
        //ARRANGE
        Long id = 45545L;
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);
        StudentDTO student = new StudentDTO(id, "Student", "Student", 6.6, Arrays.asList(materia));

        //ACT
        studentController.removeStudent(id);

        //ASSERT
        verify(studentService, atLeastOnce()).delete(id);
    }

    @Test
    void listStudents() {

    }
}
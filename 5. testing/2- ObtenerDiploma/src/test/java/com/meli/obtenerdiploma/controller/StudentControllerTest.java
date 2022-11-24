package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @DisplayName("US0001 - registerStudent OK")
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

    @DisplayName("US0002 - getStudent OK")
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

    @DisplayName("US0003 - modifyStudent OK")
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

    @DisplayName("US0004 - removeStudent OK")
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


    @DisplayName("US0005 - listStudents OK")
    @Test
    void listStudents() {
        //ARRANGE
        SubjectDTO materia1 = new SubjectDTO("Lengua", 6.6);
        StudentDTO student1 = new StudentDTO(123345L, "Student", "Student", 6.6, Arrays.asList(materia1));
        SubjectDTO materia2 = new SubjectDTO("Lengua", 6.6);
        StudentDTO student2 = new StudentDTO(45634L, "Student", "Student", 6.6, Arrays.asList(materia2));
        SubjectDTO materia3 = new SubjectDTO("Lengua", 6.6);
        StudentDTO student3 = new StudentDTO(2345678L, "Student", "Student", 6.6, Arrays.asList(materia3));

        Set<StudentDTO> listaMock = new HashSet<>();
        listaMock.add(student1);
        listaMock.add(student2);
        listaMock.add(student3);

        when(studentService.getAll()).thenReturn(listaMock);

        //ACT
        Set<StudentDTO> result = studentController.listStudents();

        //ASSERT
        verify(studentService, atLeastOnce()).getAll();

        //assertEquals(listaMock, result);
    }
}
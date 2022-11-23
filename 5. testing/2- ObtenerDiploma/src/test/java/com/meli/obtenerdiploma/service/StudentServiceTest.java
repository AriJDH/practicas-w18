package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentServiceTest {
    @Mock
    IStudentRepository studentRepository;

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    @DisplayName("US0001 - CreateStudent Ok")
    @Test
    void createTest() {
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);
        StudentDTO student = new StudentDTO(123345L, "Student", "Student", 6.6, Arrays.asList(materia));

        studentService.create(student);

        verify(studentDAO,atLeastOnce()).save(student);
    }

    @DisplayName("US002- readStudent OK")
    @Test
    void readTest() {
        //ARRANGE
        Long id = 123345L;
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);

        StudentDTO student = new StudentDTO(id, "Student", "Student", 6.6, Arrays.asList(materia));

        when(studentDAO.findById(id)).thenReturn(student);

        //ACTED
        StudentDTO readResult = studentService.read(id);

        //ASSERT
        assertEquals(student, readResult);
    }

    @DisplayName("US003- updateStudent OK")
    @Test
    void updateTest() {
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);
        StudentDTO student = new StudentDTO(123345L, "Student", "Student", 6.6, Arrays.asList(materia));

        studentService.update(student);

        verify(studentDAO,atLeastOnce()).save(student);
    }

    @DisplayName("US004- deleteStudent OK")
    @Test
    void deleteTest() {
        Long id = 123345L;
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);
        StudentDTO student = new StudentDTO(id, "Student", "Student", 6.6, Arrays.asList(materia));

        studentService.delete(id);

        verify(studentDAO,atLeastOnce()).delete(id); //debe llamarse al menos una vez
    }

    @DisplayName("US005- findAllStudent OK")
    @Test
    void getAllTest() {
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

        when(studentRepository.findAll()).thenReturn(listaMock);

        Set<StudentDTO> result = studentService.getAll();

        verify(studentRepository, atLeastOnce()).findAll();
    }
}
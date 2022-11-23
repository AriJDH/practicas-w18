package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObtenerDiplomaServiceTest {

    @Mock
    StudentRepository userRepository;

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("US0001 - Analizar puntuaciones OK")
    void analyzeScores() {
        Long id = 123345L;
        SubjectDTO materia = new SubjectDTO("Lengua", 6.6);
        StudentDTO student = new StudentDTO(id, "Student", "Student", 6.6, Arrays.asList(materia));

        when(studentDAO.findById(id)).thenReturn(student);

        StudentDTO studentResult = obtenerDiplomaService.analyzeScores(id);

        assertEquals(studentResult, student);
        //esto esta bien?????
    }

    @Test
    void getGreetingMessageTest() {

    }

    @Test
    void calculateAverageTest() {

    }
}
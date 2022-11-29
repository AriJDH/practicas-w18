package com.meli.obtenerdiploma.unitTestConMockls.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    //1. CREAR EL MOCK
    @Mock
    IStudentDAO studentDAO;

    //2. INYECTAR EL MOCK
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analyze scores HAPPY PATH :)")
    void analyzeScoresOk() {
        //ARRANGE
        SubjectDTO subject1 = new SubjectDTO("Math", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Biology", 8.0);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2);
        StudentDTO student1= new StudentDTO(1L, "Ronnie", "mensaje mock1",subjects);

        StudentDTO stu = studentDAO.findById(1L);
        Mockito.when(studentDAO.findById(student1.getId())).thenReturn(student1);
        //ACT
        StudentDTO result = obtenerDiplomaService.analyzeScores(student1.getId());
        //ASSERT
        assertAll("Datos correctos",
                // Promedio
                () -> assertEquals(9.0, result.getAverageScore()),
                // Mensaje del diploma
                () -> assertEquals("El alumno Ronnie ha obtenido un promedio de 9. Puedes mejorar.",
                        result.getMessage()),
                // Coincide nombre
                () -> assertEquals(student1.getStudentName(), result.getStudentName()));
    }

    @Test
    @DisplayName("Analyze scores UNHAPPY PATH :(")
    void analyzeScoresNotOk() {
        //ARRANGE
        SubjectDTO subject1 = new SubjectDTO();
        SubjectDTO subject2 = new SubjectDTO("History", 7.0);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2);
        StudentDTO student2= new StudentDTO(3L, "Harry", "mensaje mock2",subjects);

        StudentDTO stu = studentDAO.findById(3L);
        Mockito.when(studentDAO.findById(student2.getId())).thenReturn(student2);
        //ACT
        //StudentDTO result = obtenerDiplomaService.analyzeScores(student2.getId());
        //ASSERT
        assertAll("Datos inexistentes",
                //Student sin promedio xq tiene una sola materia
                ()->assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(student2.getId())),
                //StundentID inexistente
                ()->assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(5L))
        );

    }

    }



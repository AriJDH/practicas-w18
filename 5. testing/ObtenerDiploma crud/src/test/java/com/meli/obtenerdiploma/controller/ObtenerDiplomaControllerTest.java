package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Mock
    private IObtenerDiplomaService iObtenerDiplomaService;

    @Test
    void analyzeScores() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

        when(iObtenerDiplomaService.analyzeScores(any())).thenReturn(studentDTO);

        StudentDTO studentPromediadoDTO = obtenerDiplomaController.analyzeScores(1L);

        assertEquals(studentPromediadoDTO.getStudentName(), studentDTO.getStudentName());
    }
}
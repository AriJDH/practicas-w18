package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObtenerDiplomaControllerTest {

    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    private StudentDTO studentExpectedDTO;

    @BeforeEach
    void setUp() {
        //ARRANGE
        this.studentExpectedDTO = new StudentDTO(1L,"juan",null,10d,new ArrayList<SubjectDTO>());
    }

    @Test
    void analyzeScores() {
        //ACT
        Mockito.when(obtenerDiplomaController.analyzeScores(1L)).thenReturn(this.studentExpectedDTO);
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);
        //ASSERT
        assertEquals(result,studentExpectedDTO);
    }
}
package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void obteniendoPromedioOk(){
        //Arrange
        SubjectDTO subject1 = new SubjectDTO("Física", 4.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 5.0);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2);

        StudentDTO stuMock = new StudentDTO(1L, "Pablo", "", 0.0, subjects);
        StudentDTO stuOk = new StudentDTO(1L, "Pablo", "El alumno Pablo ha obtenido un promedio de 4.5. Puedes mejorar.", 4.5, subjects);

        when(studentDAO.findById(any())).thenReturn(stuMock);

        //Act
        StudentDTO stuResp = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(stuOk.getMessage(), stuResp.getMessage());
        assertEquals(stuOk.getAverageScore(), stuResp.getAverageScore());
    }

    @Test
    void obteniendoPromedioSinMaterias() {
        //Arrange
        StudentDTO stuMock = new StudentDTO(1L, "Pablo", "", 0.0, null);
        when(studentDAO.findById(any())).thenReturn(stuMock);

        //Act - Assert
        assertThrows(ObtenerDiplomaException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }
}

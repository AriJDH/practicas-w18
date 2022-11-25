package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresSinHonores() {
        // arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Maths", 9.5));
        subjectDTOList.add(new SubjectDTO("English", 6.7));
        subjectDTOList.add(new SubjectDTO("Science", 8.9));
        StudentDTO studentDTOMock = new StudentDTO(11L,
                "Bean",
                "Genius",
                9.2,
                subjectDTOList);

        Mockito.when(studentDAO.findById(ArgumentMatchers.any())).thenReturn(studentDTOMock);

        Double averageExpected = (9.5 + 6.7 + 8.9) / 3;
        StudentDTO studentDTOExpected = new StudentDTO(11L,
                "Bean",
                "Genius",
                averageExpected,
                subjectDTOList);

        // act
        StudentDTO studentDTOResult = obtenerDiplomaService.analyzeScores(studentDTOMock.getId());

        // assert
        Assertions.assertEquals(studentDTOResult.getAverageScore(), studentDTOExpected.getAverageScore());
        Assertions.assertTrue(studentDTOResult.getMessage().contains("Puedes mejorar"));
    }

    @Test
    void analyzeScoresConHonores() {
        // arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Maths", 9.5));
        subjectDTOList.add(new SubjectDTO("English", 9.9));
        subjectDTOList.add(new SubjectDTO("Science", 8.9));
        StudentDTO studentDTOMock = new StudentDTO(11L,
                "Bean",
                "Genius",
                9.2,
                subjectDTOList);

        Mockito.when(studentDAO.findById(ArgumentMatchers.any())).thenReturn(studentDTOMock);

        Double averageExpected = (9.5 + 9.9 + 8.9) / 3;
        StudentDTO studentDTOExpected = new StudentDTO(11L,
                "Bean",
                "Genius",
                averageExpected,
                subjectDTOList);

        // act
        StudentDTO studentDTOResult = obtenerDiplomaService.analyzeScores(studentDTOMock.getId());

        // assert
        Assertions.assertEquals(studentDTOResult.getAverageScore(), studentDTOExpected.getAverageScore());
        Assertions.assertTrue(studentDTOResult.getMessage().contains("Felicitaciones"));
    }

    @Test
    void analyzeScoresInputDataMatchesOutputData() {
        // arrange
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Maths", 9.5));
        subjectDTOList.add(new SubjectDTO("English", 9.9));
        subjectDTOList.add(new SubjectDTO("Science", 8.9));
        StudentDTO studentDTOMock = new StudentDTO(11L,
                "Bean",
                "Genius",
                9.2,
                subjectDTOList);

        Mockito.when(studentDAO.findById(ArgumentMatchers.any())).thenReturn(studentDTOMock);

        StudentDTO studentDTOExpected = studentDTOMock;

        // act
        StudentDTO studentDTOResult = obtenerDiplomaService.analyzeScores(studentDTOMock.getId());

        // assert
        Assertions.assertEquals(studentDTOResult.getId(), studentDTOExpected.getId());
        Assertions.assertEquals(studentDTOResult.getStudentName(), studentDTOExpected.getStudentName());
    }
}
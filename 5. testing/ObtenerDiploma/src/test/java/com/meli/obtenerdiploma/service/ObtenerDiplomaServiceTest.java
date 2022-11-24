package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO iStudentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO studentExpectedDTO;

    @BeforeEach
    void setUp() {
        //ARRANGE
        this.studentExpectedDTO = new StudentDTO(1L,"juan",null,10d,new ArrayList<SubjectDTO>());
    }

    @Test
    @DisplayName("Analyze Scores - happy road")
    void analyzeScores() {
        //ACT
        Mockito.when(iStudentDAO.findById(1L)).thenReturn(studentExpectedDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        //ASSERT
        assertEquals(result.getId(),studentExpectedDTO.getId());
    }
}
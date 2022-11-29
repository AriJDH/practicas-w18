package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
class StudentDAOTest {

    @Autowired
    IStudentDAO studentDAO;

    @Test
    @DisplayName("US0001-Camino Feliz :D")
    void saveOkTest() {
        //Arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Mate",5.0);
        List<SubjectDTO> sub = Arrays.asList(subjectDTO1);
        StudentDTO studentDTO = new StudentDTO(1L,"Maca","Hola",8.0,sub);
        //Act
        studentDAO.save(studentDTO);
        //Assert
        //verify(studentDAO.save(studentDTO),atLeast(1));
        assertTrue(studentDAO.exists(studentDTO));

    }

    @Test
    @DisplayName("US0001-Camino no feliz :(")
    void saveNullTest() {
        //Arrange
        StudentDTO studentDTO = null;
        //Act
        //Assert
        assertThrows(NullPointerException.class,()->studentDAO.save(studentDTO));

    }

    @Test
    @DisplayName("US0002-Camino Feliz :D")
    void deleteOkTest() {
        //Arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Mate",5.0);
        List<SubjectDTO> sub = Arrays.asList(subjectDTO1);
        StudentDTO studentDTO = new StudentDTO(1L,"Maca","Hola",8.0,sub);
        //Act
        studentDAO.delete(studentDTO.getId());
        //Assert
        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("US0002-Camino no feliz :D")
    void deleteNullTest() {
        //Arrange
        StudentDTO studentDTO = null;
        //Act
        //Assert
        assertThrows(NullPointerException.class,()->studentDAO.save(studentDTO));
    }

    @Test
    void existsOkTest() {

    }

    @Test
    void findById() {
    }
}
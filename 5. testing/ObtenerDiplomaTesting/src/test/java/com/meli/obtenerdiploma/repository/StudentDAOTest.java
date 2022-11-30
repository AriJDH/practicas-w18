package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    private StudentDAO studentDAO = new StudentDAO();

    @BeforeEach
    void setUp() {

    }

    @Test
    void saveOKTest() {
        //Arrange
        SubjectDTO subjectDTO1 = new SubjectDTO("Testing", 4.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Fury", 9.0);
        StudentDTO studentDTO = new StudentDTO(1l, "Ximena", "",0.0, Arrays.asList(subjectDTO1, subjectDTO2));
        //Act
        //Assert
        assertThrows(NullPointerException.class, ()-> studentDAO.save(studentDTO));
    }

    @Test
    void saveNullTest() {
        //Arrange
        StudentDTO studentDTO = null;
        //Act
        //Assert
        assertThrows(NullPointerException.class, ()-> studentDAO.save(studentDTO));
    }

    @Test
    void deleteTest() {
    }

    @Test
    void existsTest() {
    }

    @Test
    void findByIdTest() {
    }
}
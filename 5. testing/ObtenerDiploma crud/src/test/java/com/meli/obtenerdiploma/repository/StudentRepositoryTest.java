package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository;

    @BeforeEach
    @AfterEach
    void setUp() {
        TestGenerator.emptyUsersFile();
    }

    @Test
    @DisplayName("Obtener lista")
    void findAll() {
        //Act
        Set<StudentDTO> studentDTOList = studentRepository.findAll();
        //Assert
        assertEquals(studentDTOList.size(),0);

    }
}

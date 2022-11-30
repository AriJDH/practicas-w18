package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("get All")
    void getAllStudents() {
        Set<StudentDTO> setStudentDTO = studentRepository.findAll();

        Assertions.assertTrue(setStudentDTO.size() > 0);
    }
}

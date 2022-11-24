package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @InjectMocks
    private StudentRepository studentRepository;

    @Test
    void getAllStudents(){
        studentRepository.findAll();
    }
}

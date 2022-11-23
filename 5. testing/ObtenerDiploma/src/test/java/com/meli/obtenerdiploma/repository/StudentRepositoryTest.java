package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentRepositoryTest {

    @Mock
    IStudentRepository iStudentRepository;

    private Set<StudentDTO> studentExpectedSet;

    @BeforeEach
    void setUp() {
        //ARRANGE
        this.studentExpectedSet = new HashSet<>();
        this.studentExpectedSet.add(new StudentDTO());
    }

    @Test
    @DisplayName("Find all - happy road")
    void findAll() {
        //ACT
        Mockito.when(iStudentRepository.findAll()).thenReturn(studentExpectedSet);
        Set<StudentDTO> studentDTOList = iStudentRepository.findAll();
        //ASSERT
        assertEquals(studentDTOList,studentExpectedSet);
    }

    @Test
    @DisplayName("Find all - case null")
    void findAllNull() {
        //ACT
        Mockito.when(iStudentRepository.findAll()).thenReturn(null);
        Set<StudentDTO> studentDTOList = iStudentRepository.findAll();
        //ASSERT
        assertEquals(studentDTOList,null);
    }

}
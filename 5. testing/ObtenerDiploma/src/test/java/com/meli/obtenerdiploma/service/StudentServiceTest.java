package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;
    @Mock
    IStudentRepository iStudentRepository;
    @InjectMocks
    StudentService studentService;
    private StudentDTO studentTestDTO;
    private StudentDTO studentExpectedDTO;
    private Set<StudentDTO> setStudentExpectedDTO;

    @BeforeEach
    void setUp() {
        this.studentTestDTO = new StudentDTO();
        this.studentExpectedDTO = new StudentDTO(1L,"juan",null,10d,new ArrayList<SubjectDTO>());
        this.setStudentExpectedDTO = new HashSet<>();
        this.setStudentExpectedDTO.add(this.studentExpectedDTO);
    }

    @Test
    @DisplayName("Create student - happy road")
    void create() {
        //ACT
        studentService.create(studentTestDTO);
        //ASSERT
        Mockito.verify(iStudentDAO,Mockito.times(1)).save(studentTestDTO);
    }

    @Test
    @DisplayName("Read student - happy road")
    void read() {
        //ACT
        Mockito.when(iStudentDAO.findById(1L)).thenReturn(studentExpectedDTO);
        StudentDTO result = studentService.read(1L);
        //ASSERT
        assertEquals(result,studentExpectedDTO);
    }

    @Test
    void update() {
        //ACT
        studentService.update(studentTestDTO);
        //ASSERT
        Mockito.verify(iStudentDAO,Mockito.times(1)).save(studentTestDTO);
    }

    @Test
    void delete() {
        //ACT
        studentService.delete(1L);
        //ASSERT
        Mockito.verify(iStudentDAO,Mockito.times(1)).delete(1L);
    }

    @Test
    void getAll() {
        //ACT
        Mockito.when(iStudentRepository.findAll()).thenReturn(setStudentExpectedDTO);
        Set<StudentDTO> result = iStudentRepository.findAll();
        //ASSERT
        assertEquals(result,setStudentExpectedDTO);
    }
}
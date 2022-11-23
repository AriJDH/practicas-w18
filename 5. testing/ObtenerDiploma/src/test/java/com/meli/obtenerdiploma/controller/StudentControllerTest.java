package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentControllerTest {

    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentController studentController;

    private StudentDTO studenTestDTO;
    private StudentDTO studentExpected;
    private Set<StudentDTO> setStudentExpected;

    @BeforeEach
    void setUp() {
        //ARRANGE
        this.studenTestDTO = new StudentDTO(1L,"juan",null,Double.NaN,null);
        this.studentExpected = new StudentDTO(1L,"juan",null,Double.NaN,null);
        this.setStudentExpected = new HashSet<>();
        this.setStudentExpected.add(studentExpected);
    }

    @Test
    void registerStudent() {
        //ACT
        studentController.registerStudent(studenTestDTO);
        //ASSERT
        Mockito.verify(studentService,Mockito.times(1)).create(studenTestDTO);
    }

    @Test
    void getStudent() {
        //ACT
        Mockito.when(studentService.read(studenTestDTO.getId())).thenReturn(studentExpected);
        StudentDTO result = studentController.getStudent(studenTestDTO.getId());
        //ASSERT
        assertEquals(result,studentExpected);
    }

    @Test
    void modifyStudent() {
        //ACT
        studentController.modifyStudent(studenTestDTO);
        //ASSERT
        Mockito.verify(studentService,Mockito.times(1)).update(studenTestDTO);
    }

    @Test
    void removeStudent() {
        //ACT
        studentController.removeStudent(studenTestDTO.getId());
        //ASSERT
        Mockito.verify(studentService,Mockito.times(1)).delete(studenTestDTO.getId());
    }

    @Test
    void listStudents() {
        //ACT
        Mockito.when(studentService.getAll()).thenReturn(setStudentExpected);
        Set<StudentDTO> result = studentController.listStudents();
        //ASSERT
        assertEquals(result,setStudentExpected);
    }
}
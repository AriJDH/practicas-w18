package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService service;
    StudentDTO studentEmpty;
    StudentDTO studentDto;
    List<SubjectDTO> subjects;

    @BeforeEach
    public void setUp() {
        studentEmpty = new StudentDTO();
        subjects = new ArrayList<SubjectDTO>();
        for (int i = 0; i < 3; i++)
            subjects.add(new SubjectDTO("subject_" + i, 1.0+i ));

        studentDto = new StudentDTO(
                1L, "Name", "message", 10.0, subjects
        );
    }

    @Test
    @DisplayName("US001 - Create new student.")
    void shouldCreateStudentTest(){
        doNothing().when(studentDAO).save(any(StudentDTO.class));
        service.create(studentDto);
        verify(studentDAO).save(studentDto);
    }

    @Test
    @DisplayName("US003 - Search student by Id")
    void shouldFindAStudentTest() {
        studentDto.setId(1L);
        when(studentDAO.findById(any())).thenReturn(studentDto);
        Assertions.assertEquals(service.read(1L), studentDto);
        verify(studentDAO).findById(1L);
    }

    @Test
    void findByIdOKTest(){

    }

    @Test
    void saveEmptyStudentTest(){

    }

    @Test
    public void deleteTest(){

    }



}

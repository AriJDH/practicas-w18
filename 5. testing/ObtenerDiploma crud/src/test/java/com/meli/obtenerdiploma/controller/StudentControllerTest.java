package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private IStudentService iStudentService;

    private StudentDTO studentDTO;

    @BeforeEach
    public void setUp() {
        this.studentDTO = TestGenerator.obtenerEstudianteNotas10();
    }
    @Test
    void registerStudent() {

        doNothing().when(iStudentService).create(any());

        ResponseEntity<?> responseEntity = studentController.registerStudent(this.studentDTO);

        assertEquals(responseEntity.getStatusCode().value(), 200, "El status debe ser 200");

        verify(iStudentService, atLeastOnce()).create(any());

    }

    @Test
    void getStudent() {

        when(iStudentService.read(any())).thenReturn(this.studentDTO);

        StudentDTO studentConsultadoDTO = studentController.getStudent(this.studentDTO.getId());

        assertEquals(studentDTO, this.studentDTO, "El estudiante consultado debe ser el mismo al del id enviado");

        verify(iStudentService, atLeastOnce()).read(any());
    }

    @Test
    void modifyStudent() {

        doNothing().when(iStudentService).update(any());

        ResponseEntity<?> responseEntity = studentController.modifyStudent(this.studentDTO);

        assertEquals(responseEntity.getStatusCode().value(), 200, "El status debe ser 200");

        verify(iStudentService, atLeastOnce()).update(any());
    }

    @Test
    void removeStudent() {

        doNothing().when(iStudentService).delete(any());

        ResponseEntity<?> responseEntity = studentController.removeStudent(this.studentDTO.getId());

        assertEquals(responseEntity.getStatusCode().value(), 200, "El status debe ser 200");

        verify(iStudentService, atLeastOnce()).delete(any());
    }

    @Test
    void listStudents() {

        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(this.studentDTO);
        when(iStudentService.getAll()).thenReturn(studentDTOSet);

        Set<StudentDTO> estudiantesConsultados = studentController.listStudents();

        List<StudentDTO> studentDTOList = new ArrayList<>(studentDTOSet);
        List<StudentDTO> estudiantesEncontradosList = new ArrayList<>(estudiantesConsultados);

        assertEquals(estudiantesEncontradosList.get(0).getStudentName(),
                studentDTOList.get(0).getStudentName(),
                "El nombre debe ser Prueba2");

        verify(iStudentService, atLeastOnce()).getAll();
    }
}
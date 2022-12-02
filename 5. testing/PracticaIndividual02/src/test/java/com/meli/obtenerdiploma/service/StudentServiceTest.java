package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Creacion exitosa")
    void create() {
        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

        doNothing().when(studentDAO).save(studentDTO);

        studentService.create(studentDTO);

        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("Leer registro")
    void read() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

        when(studentDAO.findById(any())).thenReturn(studentDTO);

        studentService.read(studentDTO.getId());

        verify(studentDAO, atLeastOnce()).findById(any());

    }

    @Test
    @DisplayName("Actualizar estudiante")
    void update() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

        doNothing().when(studentDAO).save(studentDTO);

        studentService.update(studentDTO);

        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("eliminar registro")
    void delete() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

        when(studentDAO.delete(any())).thenReturn(true);

        studentService.delete(studentDTO.getId());

        verify(studentDAO, atLeastOnce()).delete(any());
    }

    @Test
    @DisplayName("Obtener toda la informacion")
    void getAll() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

        Set<StudentDTO> studentDTOSet = new HashSet<>();
        studentDTOSet.add(studentDTO);

        when(studentRepository.findAll()).thenReturn(studentDTOSet);

        studentService.getAll();

        verify(studentRepository, atLeastOnce()).findAll();

        assertTrue(studentDTOSet.contains(studentDTO), "El set debe contener al estudiante");
    }
}
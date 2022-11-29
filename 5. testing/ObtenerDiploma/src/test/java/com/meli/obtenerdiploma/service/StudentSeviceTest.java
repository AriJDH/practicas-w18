package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class StudentSeviceTest {

    @Autowired
    IStudentService studentService;

    @Autowired
    StudentDAO studentRepository;

    @Test
    @DisplayName("U0001 - Crear estudiante - camino feliz")
    void crearEstudianteOk(){
        //Arrange
        SubjectDTO subject1 = new SubjectDTO("Matemática", 5.0);
        SubjectDTO subject2 = new SubjectDTO("Español", 5.0);
        List<SubjectDTO> subjects = Arrays.asList(subject1, subject2);

        StudentDTO estudiante = new StudentDTO(1L, "Laura", "message", 5.0, subjects);

        //Act
        studentService.create(estudiante);

        //Assert
        Assertions.assertTrue(studentRepository.exists(estudiante));
    }

    @Test
    @DisplayName("U0001 - Crear usuario nulo")
    void crearEstudianteNull(){
        //Arrange
        StudentDTO estudiante = null;

        //Act
        //Assert
        Assertions.assertThrows(NullPointerException.class, () -> studentService.create(estudiante));
    }

    @Test
    @DisplayName("U0002 - Buscar estudiante - Camino Feliz")
    void buscarEstudianteOk(){
        //Arrange
        Long id = 3L;
        StudentDTO estudiante = new StudentDTO(3L, "Emilia", null, null, null);

        //Act
        StudentDTO estudianteResp = studentService.read(id);

        //Assert
        Assertions.assertEquals(estudiante, estudianteResp);
    }

    @Test
    @DisplayName("U0002 - Usuario no encontrado")
    void buscarEstudianteNoEncontrado(){
        //Arrange
        Long id = null;

        //Act
        //Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(id));
    }

    @Test
    @DisplayName("U0003 - Modificar estudiante - Camino Feliz")
    void modificarEstudianteOk(){
        //Arrange
        StudentDTO estudiante = new StudentDTO(2L, "Augusto", null, null, null);

        //Act
        studentService.update(estudiante);

        //Assert
        Assertions.assertTrue(studentRepository.exists(estudiante));
    }

    @Test
    @DisplayName("U0003 - Modificar estudiante - Estudiante nulo")
    void modificarEstudianteNull(){
        //Arrange
        StudentDTO estudiante = null;

        //Act
        //Assert
        Assertions.assertThrows(NullPointerException.class, () -> studentService.update(estudiante));
    }

    @Test
    @DisplayName("U0003 - Modificar estudiante - Estudiante no encontrado")
    void modificarEstudianteNoEncontrado(){
        //Arrange
        StudentDTO estudiante = new StudentDTO(null, null, "prueba", null, null);

        //Act
        int sizeInicial = studentService.getAll().size();
        studentService.update(estudiante);
        int sizeFinal = studentService.getAll().size();

        System.out.println(sizeInicial);
        System.out.println(sizeFinal);
        //Assert
        Assertions.assertTrue(studentService.getAll().size()>sizeInicial);
    }

    @Test
    @DisplayName("U0004 - Eliminar estudiante - Camino Feliz")
    void eliminarEstudianteOk(){
        //Arrange
        Long id = 6L;

        //Act
        int sizeInicial = studentService.getAll().size();
        studentService.delete(id);

        //Assert
        Assertions.assertTrue(studentService.getAll().size()<sizeInicial);
    }

    @Test
    @DisplayName("U0005 - Listar estudiantes - Camino feliz")
    void listarEstudiantesOk(){
        //Arrange

        //Act
        studentService.getAll();

        //Assert
        Assertions.assertTrue(studentService.getAll().size()==5);
    }

}

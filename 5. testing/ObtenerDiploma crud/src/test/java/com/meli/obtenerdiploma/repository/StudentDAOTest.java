package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
    }

    /**
     * Prueba unitaria donde se guarda el estudiante con un nuevo id que
     * no existe
     */
    @Test
    @DisplayName("Creacion exitosa")
    public void saveSuccess() {

        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Prueba success");
        //Act
        studentDAO.save(studentDTO);
        //Assert
        //Internamente el save lo que hace es sobreescribir el id del objeto a crear, por ello
        //siempre el id sera 1
        StudentDTO studentCreadoDTO = studentDAO.findById(studentDTO.getId());

        assertEquals(studentCreadoDTO.getStudentName(), "Prueba success",
                "El nombre del estudiante debe ser Prueba success");

        assertEquals(studentCreadoDTO.getId(), 1, "El id debe ser 1");
    }

    /**
     * Prueba unitaria donde se guarda el estudiante con un id ya existente,
     * causando que se tenga que eliminar el que ya existia
     */
    @Test
    public void saveRemoved() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Student for remove");
        //Act
        studentDAO.save(studentDTO);
        //Assert
        StudentDTO estudianteExistente = studentDAO.findById(1L);

        assertNotNull(estudianteExistente);
    }

    @Test
    @DisplayName("Eliminar Estudiante")
    void delete() {
        //Act
        studentDAO.save(TestGenerator.obtenerEstudianteNotas10());
        boolean result = studentDAO.delete(1L);

        //Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Existe el usuario")
    void exists() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

        //Act
        studentDAO.save(studentDTO);
        boolean result = studentDAO.exists(studentDTO);
        //Assert
        assertTrue(result, "Debe Existir el usuario");
    }

    @Test
    void findById() {

        StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

        //Act
        studentDAO.save(studentDTO);
        StudentDTO result =studentDAO.findById(1L);

        //Assert
        assertEquals(result.getStudentName(), "Prueba2","Son los mismos Objetos");
    }

}

package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentDAOTest {

    /*Ejercicio 1
    Test Unitarios sin Mocks
    Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de repositorio StudentDAO
    y StudentRepository.
    Tener en cuenta múltiples escenarios y “casos borde” de cada comportamiento.
    - Casos nulos, vacíos, inválidos.
    - Agregar un alumno.
    - Buscar un alumno por Id.
    - Modificar los datos de un alumno.
    - Eliminar un alumno.
    - Listar todos los alumnos.
*/

    //Objeto a testear
    IStudentDAO studentDAO;


    //EO1 - Test Unitarios Sin Mock - Cubrir comportamiento de la capa de repositorio
    @BeforeEach
    public void setUp() {
        TestUtils.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }


    //EO1 - Test Unitarios Sin Mock - Cubrir comportamiento de la capa de repositorio
    //Agregar un alumno que no exista con 3 materias
    @Test
    void saveNonExistentStudent() {
        //arrange
        StudentDTO studentDTO = TestUtils.saveStudentWith3Subjects("Tana");

        //act
        studentDAO.save(studentDTO);

        //Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));

    }

    @Test
    void exists() {
        //TODO
    }

    @Test
    void findById() {
        //TODO
    }

    @Test
    void delete() {
        //TODO
    }
}
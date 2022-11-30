package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    public void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Probar StudentDAO")
    public void test1(){
        //Arrange
        boolean expected = true;

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(7L);
        studentDTO.setStudentName("Nombre estudiante");
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("nombre materia");
        subjectDTO.setScore(7.00);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(subjectDTO);
        studentDTO.setSubjects(subjectDTOS);

        //Act
        studentDAO.save(studentDTO);
        boolean exist = studentDAO.exists(studentDTO);

        //Assert
        Assertions.assertEquals(expected, exist);

    }

    @Test
    @DisplayName("Probando el método delete")
    public void test2() {
        //Arrange
        boolean expected = true;

        //Act
         boolean isDeleted = studentDAO.delete(3L);

        //
        Assertions.assertEquals(expected, isDeleted);
    }

    @Test
    @DisplayName("Probando el método delete")
    public void test3(){
        //Arrange
        boolean expected = false;

        //Act
        boolean isDeleted = studentDAO.delete(12L);

        //Assert
        Assertions.assertEquals(expected, isDeleted);
    }


    @Test
    @DisplayName("Probando el método findById")
    public void test4() {
        //Arrange
        StudentDTO studentDTOExpected = new StudentDTO();
        studentDTOExpected.setStudentName("Pedro");

        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        SubjectDTO subjectDTO1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Química", 4.0);
        subjectDTOS.add(subjectDTO1);
        subjectDTOS.add(subjectDTO2);
        subjectDTOS.add(subjectDTO3);

        studentDTOExpected.setSubjects(subjectDTOS);
        //Act
        StudentDTO studentDTO = studentDAO.findById(2L);

        //
        Assertions.assertEquals(studentDTOExpected.getStudentName(), studentDTO.getStudentName());
    }

    @Test
    @DisplayName("Probar Exception")
    public void test5(){
        //Arrange

        //Assert
        Assertions.assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(13L));
    }

}

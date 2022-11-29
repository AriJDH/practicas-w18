package com.meli.obtenerdiploma.unitTestSinMocks.repository.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();
    StudentDTO student1 = new StudentDTO();
    StudentDTO student2 = new StudentDTO();

    @BeforeEach
    void loadStudents(){
        SubjectDTO subject1 = new SubjectDTO("Math", 9.0);
        SubjectDTO subject2 = new SubjectDTO("History", 10.0);
        SubjectDTO subject3 = new SubjectDTO("Biology", 5.0);
        List<SubjectDTO> subjects1 = Arrays.asList(subject1,subject2);
        List<SubjectDTO> subjects2 = Arrays.asList(subject2,subject3);

        student1.setId(1L);
        student1.setStudentName("Estudiante1");
        student1.setSubjects(subjects1);

        student2.setId(2L);
        student2.setStudentName("Estudiante2");
        student2.setSubjects(subjects2);
    }


    @Test
    @DisplayName("Metodo SAVE() HAPPY PATH :)")
    void saveOk() {
        //ACT
        studentDAO.save(student1);
        StudentDTO result = studentDAO.findById(student1.getId());
        //ASSERT
        Assertions.assertEquals(student1.getId(), result.getId());
    }

    @Test
    @DisplayName("Metodo SAVE() UNHAPPY PATH :(")
    void saveNotOk() {
        //ARRANGE
        Long wrongId = 10L;
        //ACT
        studentDAO.save(student1);
        //ASSERT
        Assertions.assertThrows(StudentNotFoundException.class, ()->  studentDAO.findById(wrongId));
    }

    @Test
    void delete() {
    }

    @Test
    void exists() {
    }

    @Test
    void findById() {
    }
}
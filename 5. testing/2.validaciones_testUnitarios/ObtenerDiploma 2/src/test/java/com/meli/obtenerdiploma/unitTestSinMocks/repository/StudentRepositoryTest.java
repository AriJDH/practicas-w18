package com.meli.obtenerdiploma.unitTestSinMocks.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
//PASO A PASO UNIT TEST REPOSITORY SIN MOCKS
class StudentRepositoryTest {

    //1. INSTANCIO EL REPOSITORIO
    StudentRepository studentRepository = new StudentRepository();
    StudentDAO studentDAO = new StudentDAO();
    SubjectDTO subjectDTO = new SubjectDTO("Math",10.0);
    SubjectDTO subjectDTO1 = new SubjectDTO("Biology",8.0);
    List<SubjectDTO>subjectlist = Arrays.asList(subjectDTO, subjectDTO1);
    //creo un student
    StudentDTO student = new StudentDTO("Sofia",subjectlist);

    //2.METODO QUE VOY A TESTEAR
    @Test
    @DisplayName("test addStudent & findById() OK from studentDAO")
    void findStudentByIdOKTest() {
        //ARRANGE
        //ACT
        studentDAO.save(student);
        StudentDTO studentDTOfound = studentDAO.findById(13L);
        //ASSERT
        Assertions.assertEquals(student,studentDTOfound);
    }

    @Test
    @DisplayName("test findById() FAIL from studentDAO")
    void StudentFoundByIdFAILTest() {
        //ARRANGE
        //ACT
        studentDAO.save(student);
       //StudentDTO studentDTOfound = studentDAO.findById(1L);
        //ASSERT
        Assertions.assertThrows(StudentNotFoundException.class,
                ()-> studentDAO.findById(1L));
    }


    @Test
    @DisplayName("test delete() OK from studentDAO")
    void deleteStudentByIdOKTest() {
        //ARRANGE
        //ACT
        studentDAO.save(student);
        Boolean studentDeleted = studentDAO.delete(13L);
        //Set<StudentDTO> result = studentRepository.findAll();
        //int sizeResult = result.size();
        //ASSERT
        Assertions.assertTrue(studentDeleted);

    }

    @Test
    @DisplayName("test delete() FAIL from studentDAO")
    void deleteStudentByIdFAILTest() {
        //ARRANGE
        //ACT
        studentDAO.save(student);
        Boolean studentDeleted = studentDAO.delete(1L);
        //Set<StudentDTO> result = studentRepository.findAll();
        //int sizeResult = result.size();
        //ASSERT
        Assertions.assertFalse(studentDeleted);
    }

    @Test
    @DisplayName("test findAll() OK from studentRespository")
    void findAllStudentsOKTest() {
        //ARRANGE
        //ACT

        Set<StudentDTO> result = studentRepository.findAll();
        int sizeResult = result.size();
        //ASSERT
        Assertions.assertEquals(5,sizeResult);
    }




}
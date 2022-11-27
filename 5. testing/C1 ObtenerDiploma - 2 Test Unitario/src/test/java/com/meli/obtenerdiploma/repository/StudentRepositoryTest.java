package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtils;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class StudentRepositoryTest {

    IStudentRepository studentRepository;
    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    void setUp() {
        TestUtils.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    void findAllStudentsOKTest() {
        //ARRANGE
        Set<StudentDTO> studentDTOS = TestUtils.getStudentSet();

/*        for (StudentDTO s: studentDTOS) {
            studentDAO.save(s);
        }*/

        studentDTOS.forEach((s) -> studentDAO.save(s));


        //ACT
        Set<StudentDTO> studentsFounded = studentRepository.findAll();

        //ASSERT

        Assertions.assertTrue(CollectionUtils.isEqualCollection(studentDTOS, studentsFounded));
    }
}
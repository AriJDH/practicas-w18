package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentDAOTest {

    @Autowired
    IStudentDAO studentDAO;

    @Test
    void saveNewStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(11L,
                "Bean",
                "Genius",
                9.2,
                TestUtils.generateRandomSubjectList());
        // Act
        studentDAO.save(studentDTO);
        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO));
        Assertions.assertEquals(studentDAO.findById(studentDTO.getId()), studentDTO);
    }

    @Test
    void saveExistentStudent() {
        // Arrange
        StudentDTO studentDTO1 = new StudentDTO(11L,
                "Bean",
                "Genius",
                9.2,
                TestUtils.generateRandomSubjectList());
        StudentDTO studentDTO2 = new StudentDTO(11L,
                "Bean McBeanFace",
                "Genius",
                4.1,
                TestUtils.generateRandomSubjectList());
        // Act
        studentDAO.save(studentDTO1);
        StudentDTO oldStudentDTO = studentDAO.findById(studentDTO1.getId());
        studentDAO.save(studentDTO2);
        StudentDTO newStudentDTO = studentDAO.findById(studentDTO2.getId());
        // Assert
        Assertions.assertTrue(studentDAO.exists(studentDTO2));
        Assertions.assertNotEquals(oldStudentDTO, newStudentDTO);
        Assertions.assertEquals(newStudentDTO.getStudentName(), studentDTO2.getStudentName());
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
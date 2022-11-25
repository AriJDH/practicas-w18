package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.Set;

public class StudentRepositoryTest {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilGenerator.emptyUserFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilGenerator.getStudentSet();
        students.forEach((stu) -> studentDAO.save(stu));

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));

    }


}

package com.meli.testintegracionobtenerdiploma.unit.repository;

import com.meli.testintegracionobtenerdiploma.model.StudentDTO;
import com.meli.testintegracionobtenerdiploma.repository.IStudentDAO;
import com.meli.testintegracionobtenerdiploma.repository.IStudentRepository;
import com.meli.testintegracionobtenerdiploma.repository.StudentDAO;
import com.meli.testintegracionobtenerdiploma.repository.StudentRepository;
import com.meli.testintegracionobtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import java.util.Set;

public class StudentRepositoryTests {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach((stu) -> studentDAO.save(stu));

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }

}

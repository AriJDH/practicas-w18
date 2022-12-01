package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class RepositoryTests {
    @Autowired
    private StudentDAO studentDAO;

    private StudentDTO studentDTO = new StudentDTO(0L,"Rodrigo", "Un mensaje", 10.0, new ArrayList<>());

    @BeforeEach
    public void cleanRepository(){
        studentDAO.findAll().stream().forEach(st->studentDAO.delete(st.getId()));
    }

    @Test
    public void testAddStudent(){
        studentDAO.save(studentDTO);

        Assertions.assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    public void testFindStudentById(){
        studentDAO.save(studentDTO);

        StudentDTO foundStudent = studentDAO.findById(studentDTO.getId());

        Assertions.assertEquals(foundStudent.getStudentName(), studentDTO.getStudentName());
    }

    @Test
    public void testModifyStudent(){
        studentDAO.save(studentDTO);
        StudentDTO foundStudent = studentDAO.findById(studentDTO.getId());

        foundStudent.setStudentName("Norberto");
        studentDAO.save(foundStudent);

        Assertions.assertEquals(foundStudent.getStudentName(), "Norberto");
    }

    @Test
    public void deleteStudent(){
        studentDAO.save(studentDTO);

        studentDAO.delete(studentDTO.getId());
    }

    @Test
    public void findAll(){
        studentDAO.save(studentDTO);

        Assertions.assertEquals(studentDAO.findAll().size(),1);
    }

}

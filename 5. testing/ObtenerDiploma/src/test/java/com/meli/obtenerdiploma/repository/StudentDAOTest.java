package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentDAOTest {

    @Mock
    IStudentDAO iStudentDAO;

    private StudentDTO studenTestDTO;
    private StudentDTO studentExpected;

    @BeforeEach
    void setUp() {
        studenTestDTO = new StudentDTO(1L,"juan",null,Double.NaN,null);
        studentExpected = new StudentDTO(1L,"juan",null,Double.NaN,null);
    }

    @Test
    @DisplayName("Save StudenDAO - happy road")
    void save() {
        //ACT
        iStudentDAO.save(studenTestDTO);
        //ASSERT
        Mockito.verify(iStudentDAO,Mockito.times(1)).save(studenTestDTO);
    }

    @Test
    @DisplayName("Save null StudenDAO - case null")
    void saveNull() {
        //ACT
        // se prepara mockito para engañarlo y decir que se va a retornar un RuntimeException cuando se llame la funcion save
        Mockito.doThrow(new RuntimeException())
                .when(iStudentDAO)
                .save(null);
        //ASSERT
        assertThrows(RuntimeException.class, () ->  iStudentDAO.save(null) );
    }

    @Test
    @DisplayName("Delete StudenDAO - happy road")
    void delete() {
        //ACT
        iStudentDAO.delete(studenTestDTO.getId());
        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.times(1)).delete(studenTestDTO.getId());
    }

    @Test
    @DisplayName("Delete null StudenDAO - case null")
    void deleteNull() {
        //ACT
        // se prepara mockito para engañarlo y decir que se va a retornar un RuntimeException cuando se llame la funcion delete
        Mockito.doThrow(new StudentNotFoundException(null))
                .when(iStudentDAO)
                .delete(null);
        //ASSERT
        assertThrows(RuntimeException.class, () ->  iStudentDAO.delete(null) );
    }

    @Test
    @DisplayName("Exists StudenDAO - happy road")
    void exists() {
        //ACT
        iStudentDAO.exists(studenTestDTO);
        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.times(1)).exists(studenTestDTO);
    }

    @Test
    @DisplayName("FindByName StudenDAO - happy road")
    void findById() {
        //ACT
        iStudentDAO.findById(studenTestDTO.getId());
        //ASSERT
        Mockito.verify(iStudentDAO, Mockito.times(1)).findById(studenTestDTO.getId());
    }
}
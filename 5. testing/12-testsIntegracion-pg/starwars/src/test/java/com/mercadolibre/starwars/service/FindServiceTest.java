package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void find() {
        // arrange
//        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
//        when(studentDAO.findById(stu.getId())).thenReturn(stu);



        // act
//        StudentDTO readStu = service.read(stu.getId());



        // assert
//        verify(studentDAO, atLeastOnce()).findById(stu.getId());
//        assertEquals(stu, readStu);



    }
}
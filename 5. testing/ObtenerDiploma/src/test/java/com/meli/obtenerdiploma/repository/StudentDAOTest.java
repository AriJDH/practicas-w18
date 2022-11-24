package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

        @InjectMocks
        private StudentDAO studentDAO;

        @Test
        void addStudent() {
            SubjectDTO subject1 = new SubjectDTO("Barquitos", 8.2);
            SubjectDTO subject2 = new SubjectDTO("Coaching de League of legends", 2.3);
            SubjectDTO subject3 = new SubjectDTO("Liderazgo", 3.2);
            SubjectDTO subject4 = new SubjectDTO("Social y civil", 1.9);
            List<SubjectDTO> subjects = Stream.of(subject1, subject2, subject3, subject4).collect(Collectors.toList());
            StudentDTO studentDTO = new StudentDTO(1L, "Axel Palombo", "Recien ahora voy a desayunar", 4.5, subjects);

            studentDAO.save(studentDTO);

        }

        @Test
        void getExistentStudentById() {

            StudentDTO result = studentDAO.findById(1L);

            assertEquals(result.getId(), 1);
            assertEquals(result.getStudentName(), "Juan");
            assertEquals(result.getSubjects().size(), 3);
        }

        @Test
        void getNotExistentStudentById() {

            StudentDTO result = studentDAO.findById(7L);
            // ver clase...
        }

        @Test
        void deleteExistentStudentById(){
           studentDAO.delete(1L);
        }

        @Test
        void  nonExistingStudent(){
            studentDAO.findById(null);
        }

}

package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationObtenerDiplomaTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void testIntegracion() throws Exception {

        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setId(1L);
        studentDTO.setSubjects(new ArrayList<>());

        String studentJson = new ObjectMapper().writeValueAsString(studentDTO);
        String payload = new ObjectMapper().writeValueAsString(studentDTO);


        //MATCHERS
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(studentJson);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //REQUEST
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1)
                                                                             .contentType(MediaType.APPLICATION_JSON).content(payload);

        //ACT & ASSERT
        mvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);

    }
/*
    @BeforeAll //se va a ejecutar antes de todos los test
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach //se va a ejecutar antes del test que viene
    public void beforEach() {
        subjectDTO1 = new SubjectDTO("Matemática", 9.0);
        subjectDTO2 = new SubjectDTO("Física", 7.0);
        subjectDTO3 = new SubjectDTO("Química", 6.0);

        studentDTO = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.33, List.of(subjectDTO1, subjectDTO2, subjectDTO3));

        if (!studentDAO.exists(studentDTO)) {
            studentDAO.save(studentDTO);
        }
    }

    @Test
    @DisplayName("test con id de usuario, obtener diploma con promedio")
    public void testObtener() throws Exception {
        String userJson = writer.writeValueAsString(studentDTO);
        System.out.println(userJson);

        ResultMatcher estadoEsperado = status().isOk();
        ResultMatcher jsonEsperado = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1);

        mvc.perform(request)
               .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedContentType)
                .andExpect(jsonEsperado)
                .andExpect(estadoEsperado);

 */

/*
*         String userJson = writer.writeValueAsString(studentDTO);
        System.out.println(userJson);

        this.mvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(userJson))
                .andExpect(status().isOk());

* */

    }


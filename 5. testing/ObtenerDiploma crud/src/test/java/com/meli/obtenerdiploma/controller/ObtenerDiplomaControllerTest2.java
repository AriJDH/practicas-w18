package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    private static StudentDAO studentDAO = new StudentDAO();

    @BeforeEach @AfterEach
    public void beforEach() {
        TestGenerator.emptyUsersFile();

        SubjectDTO kahoot = new SubjectDTO("Kahoot", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO poo    = new SubjectDTO("POO",    2.0);

        StudentDTO student = new StudentDTO(1L, "Juan","El alumno Juan ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

        if( ! studentDAO.exists( student ) ) {
            studentDAO.save( student );
        }

    }

    @Test
    @DisplayName("Estudiante promediado correctamente")
    public void analyzeScores() {

        try {
            MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                    .andDo(print())
                    .andExpect(status().isOk())
                    //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                    .andReturn();

            assertEquals("application/json", mvcResult.getResponse().getContentType());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("No existe el estudiante a promediar")
    public void analyzeScoresError() {

        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3L))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                    .andExpect(jsonPath(("$.description")).value("El alumno con Id 3 no se encuetra registrado."));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

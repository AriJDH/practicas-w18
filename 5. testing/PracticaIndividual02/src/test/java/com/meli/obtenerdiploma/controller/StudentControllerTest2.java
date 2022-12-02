package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Creacion de estudiante")
    public void createStudent() {

        try {
            StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();

            ObjectWriter objectWriter = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer();

            String studentDTOString = objectWriter.writeValueAsString(studentDTO);

            this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(studentDTOString))
                    .andDo(print())
                    .andExpect(status().isOk());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Creacion de estudiante erronea, nombre vacio")
    public void createStudent2() {

        try {
            StudentDTO studentDTO = TestGenerator.obtenerEstudianteNotas10();
            studentDTO.setStudentName(" ");

            ObjectWriter objectWriter = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer();

            String studentDTOString = objectWriter.writeValueAsString(studentDTO);

            this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(studentDTOString))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    @BeforeEach
    public void limpiarJson() {
        TestGenerator.emptyUsersFile();
    }
}
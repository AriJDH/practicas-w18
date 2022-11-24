package com.meli.testintegracionobtenerdiploma.integration;

import com.meli.testintegracionobtenerdiploma.model.StudentDTO;
import com.meli.testintegracionobtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    private StudentDTO studentTestDTO;

    @BeforeEach
    void setUp() {
        //ARRANGE
        this.studentTestDTO = TestUtilsGenerator.getStudentWithId(1L);
    }

    @Test
    @DisplayName("US000 - Analize score happy path")
    void analyzeScores() throws Exception {
        //ACT
        mockMvc.perform(
                        get("/analyzeScores/{studentId}", this.studentTestDTO.getId())
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("US001 - Analize score not happy path")
    void analyzeScoresStudentNull() throws Exception {
        //ACT
        MvcResult result = mockMvc.perform(
                        get("/analyzeScores/{studentId}", -1L)
                )
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }
}
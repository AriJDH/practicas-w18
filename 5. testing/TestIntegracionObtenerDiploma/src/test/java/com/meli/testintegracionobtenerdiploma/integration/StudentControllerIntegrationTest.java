package com.meli.testintegracionobtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private StudentDTO studentTestDTO;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        //ARRANGE
        this.studentTestDTO = TestUtilsGenerator.getStudentWithId(2L);
        this.objectMapper= new ObjectMapper();
    }

    @Test
    @DisplayName("US000 - Register student happy path")
    void registerStudent() throws Exception {
        //ACT
        mockMvc.perform(
                        post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(studentTestDTO))
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US001 - Get student happy path")
    void getStudent() throws Exception {
        //ACT
        MvcResult mvcResult = mockMvc.perform(
                        get("/student/getStudent/{id}", 2L)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andReturn();
        //ASSERT
        Long id = Long.parseLong(JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.id").toString());
        assertEquals(2L,id);
    }

    @Test
    @DisplayName("US002 - Update student happy path")
    void modifyStudent() throws Exception {
        //ACT
        mockMvc.perform(
                        post("/student/modifyStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(studentTestDTO))
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US003 - Delete student happy path")
    void removeStudent() throws Exception {
        //ACT
        mockMvc.perform(
                        get("/student/removeStudent/{id}", 2L)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("US004 - Get list student happy path")
    void listStudents() throws Exception {
        mockMvc.perform(
                        get("/student/listStudents")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
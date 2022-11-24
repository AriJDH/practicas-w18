package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentDAO studentDAO;
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void deleteRepo(){
        studentDAO.deleteAll();
    }

    @Test
    public void registerStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        String content = this.objectMapper.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void registerStudentFailed() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("marco");
        String content = this.objectMapper.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getSudent() throws Exception {
        studentDAO.save(TestUtilsGenerator.getStudentWith3Subjects("Rodrigo"));
        this.mockMvc.perform(get("/student/getStudent/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Rodrigo"));
    }

    @Test
    public void getSudentNotFound() throws Exception {
        this.mockMvc.perform(get("/student/getStudent/10"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void modifiyStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(studentDTO);
        studentDTO.setStudentName("Norberto");
        String content = this.objectMapper.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void removeStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(studentDTO);
        this.mockMvc.perform(get("/student/removeStudent/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void listStudents() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(studentDTO);
        this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].studentName").value("Marco"));
    }
}

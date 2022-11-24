package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StudentDAO studentDAO;

    @BeforeEach
    public void deleteRepo(){
        studentDAO.deleteAll();
    }

    @Test
    public void analyzeScoresOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(studentDTO);
        this.mockMvc.perform(get("/analyzeScores/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Marco"))
                .andExpect(jsonPath("$.averageScore").value(6.0))
                .andExpect(jsonPath("$.subjects.length()").value(3));
    }

    @Test
    public void analyzeScoresNotFoundStudent() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/10"))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }
}

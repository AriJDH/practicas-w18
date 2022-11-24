package com.meli.obtenerdiploma.integration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationStudentTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void integrationRegisterStudent() throws Exception
    {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Name 1", 7.0));
        subjectDTOList.add(new SubjectDTO("Name 2", 8.0));
        subjectDTOList.add(new SubjectDTO("Name 3", 9.0));
        StudentDTO studentDTO = new StudentDTO(5L, "Alberto", "Bienmnnnnnnn",
                8.0, subjectDTOList);
        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadDto = objectWriter.writeValueAsString(studentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadDto))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void integrationFindStudentById() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 5))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
                //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }

    @Test
    void integrationModifyStudent() throws Exception
    {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Name 1", 7.0));
        subjectDTOList.add(new SubjectDTO("Name 2", 8.0));
        subjectDTOList.add(new SubjectDTO("Name 3", 9.0));
        StudentDTO studentDTO = new StudentDTO(5L, "Alberto", "Bienmnnnnnnn",
                8.0, subjectDTOList);
        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadDTO = objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadDTO))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void integrationRemoveStudent() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void integrationListAllStudent() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
}

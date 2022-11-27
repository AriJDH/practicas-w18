package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	
	@Test
	void integrationOkTest() throws Exception {
		
		// ARRANGE
		// Creamos nuestros DTO
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe Mock");
		studentDTO.setMessage("Message Ok Mock");
		studentDTO.setSubjects(subjectDTOList);
		
		// Pasamos nuestros DTO a String
		String studentJson = mapper.writeValueAsString(studentDTO);
		String payload = mapper.writeValueAsString(studentDTO);
		
		// Matchers
		ResultMatcher expectedStatus = MockMvcResultMatchers
						.status()
						.isOk();
		ResultMatcher expectedJson = MockMvcResultMatchers
						.content()
						.json(studentJson);
		ResultMatcher expectedContentType = MockMvcResultMatchers
						.content()
						.contentType(MediaType.APPLICATION_JSON);
		
		// Requests
		MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
						.post("/student/registerStudent")
						.contentType(MediaType.APPLICATION_JSON)
						.content(payload);
		
		// ACT - ASSERTS
		mockMvc
						.perform(requestPayload)
						.andDo(print())
						.andExpect(expectedStatus)
						.andExpect(expectedJson)
						.andExpect(expectedContentType);
	}
	
}

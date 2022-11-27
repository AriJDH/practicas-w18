package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@Test
	@DisplayName("US0014 - Método Get Listar estudiantes happy path =^.^=")
	void listStudentsOkTest() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
						                                      .get("/student/listStudents"))
						.andDo(print())
						.andExpect(status()
										           .isOk())
						.andExpect(content()
										           .contentType("application/json"))
						.andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	@DisplayName("US0015 - Método Post happy path =^.^=")
	void registerStudentOkTest() throws Exception {
		
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe Mock");
		studentDTO.setMessage("Message Ok Mock");
		studentDTO.setSubjects(subjectDTOList);
		
		ObjectWriter writer = new ObjectMapper()
						.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
						.writer();
		
		String payloadDto = writer.writeValueAsString(studentDTO);
		MvcResult mvcResult;
		mvcResult = mockMvc.perform(
										post("/student/registerStudent")
														.contentType(MediaType.APPLICATION_JSON)
														.content(payloadDto))
						.andDo(print())
						.andExpect(content()
										           .contentType("application/json"))
						.andReturn();
		
		assertEquals(payloadDto, mvcResult.getResponse().getContentAsString());
		
	}
	
	@Test
	@DisplayName("US0016 - Método Get buscar un estudiante happy path =^.^=")
	void getStudentByIdOkTest() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
						                                      .get("/student/getStudent/1"))
						.andDo(print())
						.andExpect(status()
										           .isOk())
						.andExpect(content()
										           .contentType("application/json"))
						.andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	@DisplayName("US0017 - Método Put happy path =^.^=")
	void modifyStudentOkTest() throws Exception {
		
		List<SubjectDTO> subjectDTOList = new ArrayList<>();
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		subjectDTOList.add(new SubjectDTO("Maths", 10.0));
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(1L);
		studentDTO.setStudentName("Pepe Mock");
		studentDTO.setMessage("Message Modificado");
		studentDTO.setSubjects(subjectDTOList);
		
		ObjectWriter writer = new ObjectMapper()
						.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
						.writer();
		
		String payloadDto = writer.writeValueAsString(studentDTO);
		MvcResult mvcResult;
		mvcResult = mockMvc.perform(
										post("/student/registerStudent")
														.contentType(MediaType.APPLICATION_JSON)
														.content(payloadDto))
						.andDo(print())
						.andExpect(content()
										           .contentType("application/json"))
						.andReturn();
		
		assertEquals(payloadDto, mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	@DisplayName("US0018 - Método Delete para eliminar un estudiante happy path =^.^=")
	void deleteStudentByIdOkTest() throws Exception {
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
						                                      .delete("/student/removeStudent/1"))
						.andDo(print())
						.andExpect(status()
										           .isOk())
						.andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
}

package com.example.livecodingtest.controller;

import com.example.livecodingtest.dto.ErrorDto;
import com.example.livecodingtest.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void intTest() throws Exception {
		MvcResult mvcResult = mockMvc
						.perform(MockMvcRequestBuilders
										         .get("/getAllUsers"))
						.andDo(print())
						.andExpect(status()
										           .isOk())
						.andExpect(content()
										           .contentType("application/json"))
						.andReturn();
		
		System.out.println(mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void integracionPostTest() throws Exception {
		UserDto userDto = new UserDto("Martin", "Marquez", 30);
		
		ObjectWriter writer = new ObjectMapper()
						.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
						.writer();
		
		String payloadDto = writer.writeValueAsString(userDto);
		
		MvcResult mvcResult = mockMvc
						.perform(
										post("/createUser")
						                                      .contentType(MediaType.APPLICATION_JSON)
						                                      .content(payloadDto))
						.andDo(print())
						.andExpect(content()
										           .contentType("application/json"))
						.andReturn();
		
		assertEquals(payloadDto, mvcResult.getResponse().getContentAsString());
	}
	
	@Test
	void validacionFallidaTest() throws Exception {
		UserDto userDto = new UserDto("Martin", "Marquez", 123);
		
		ErrorDto errorDto = new ErrorDto("No puede tener mas de 99 years.");
		
		ObjectWriter writer = new ObjectMapper()
						.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
						.writer();
		
		String payloadDto = writer.writeValueAsString(userDto);
		String errorExpected = writer.writeValueAsString(errorDto);
		
		MvcResult mvcResult = mockMvc.perform(post("/createUser")
						                                      .contentType(MediaType.APPLICATION_JSON)
						                                      .content(payloadDto))
						.andDo(print())
						.andReturn();
		
		assertEquals(errorExpected, mvcResult.getResponse().getContentAsString());
	}
}

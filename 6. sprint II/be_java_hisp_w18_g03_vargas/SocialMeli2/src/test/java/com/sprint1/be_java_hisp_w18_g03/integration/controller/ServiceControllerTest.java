package com.sprint1.be_java_hisp_w18_g03.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint1.be_java_hisp_w18_g03.dto.response.FollowerCountDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import com.sprint1.be_java_hisp_w18_g03.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
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


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class ServiceControllerTest {
				@Autowired
				MockMvc mockMvc;

				@Test
				@DisplayName("Obtener la cantidad de seguidores")
				void followerCount() throws Exception {

								//Arrange
								FollowerCountDTO followerCountDTO = UserFactory.getCountFolowerUser();
								String dtoJson = new ObjectMapper().writeValueAsString(followerCountDTO);
								/* Matchers */
								ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
								ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
								ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(dtoJson);
								/* Request */
								MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
																.get("/users/{userId}/followers/count",1);
								// Act & Assert
								mockMvc
																.perform(requestPayload)
																.andDo(print())
																.andExpectAll(expectedStatus, expectedContentType, expectedJson);
				}

/*				@Test
				@DisplayName("Seguir a una persona")
				void followOk() throws Exception {

								//Arrange
								ResponseDTO responseDTO = new ResponseDTO();
								responseDTO.setCode(200);
								responseDTO.setMessage("All ok");
								String dtoJson = new ObjectMapper().writeValueAsString(responseDTO);
								*//* Matchers *//*
								ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
								ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
								ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(dtoJson);
								*//* Request *//*
								MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
																.post("/users/{userId}/follow/{userIdToFollow}")
																.contentType(MediaType.APPLICATION_JSON)
																.content(String.valueOf(1),String.valueOf(2));
								// Act & Assert
								mockMvc
																.perform(requestPayload)
																.andDo(print())
																.andExpectAll(expectedStatus, expectedContentType, expectedJson);
				}*/

}

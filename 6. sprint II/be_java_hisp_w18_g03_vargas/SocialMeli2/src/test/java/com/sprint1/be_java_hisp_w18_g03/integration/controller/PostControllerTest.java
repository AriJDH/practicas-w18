package com.sprint1.be_java_hisp_w18_g03.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint1.be_java_hisp_w18_g03.Repository.IPostRepository;
import com.sprint1.be_java_hisp_w18_g03.Repository.IUserRepository;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.SellersPostDTO;
import com.sprint1.be_java_hisp_w18_g03.entity.User;
import com.sprint1.be_java_hisp_w18_g03.service.PostServiceImp;
import com.sprint1.be_java_hisp_w18_g03.utils.PostFactory;
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

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerTest {

				@Autowired
				 MockMvc mockMvc;

				@Test
				@DisplayName("Crear una publicacion")
				void createPostOk() throws Exception {
								// Arrange
								ObjectWriter writer = new ObjectMapper()
																.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
																.registerModule(new JavaTimeModule())
																.writer();

								RequestPostDTO requestPostDTO = PostFactory.getRequestPostDTO();
								String payload = writer.writeValueAsString(requestPostDTO);

								/* Matchers */
								ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
								ResultMatcher expectedMessage = MockMvcResultMatchers.jsonPath("$.message").value("Post added successfully");
								ResultMatcher expectedCode = MockMvcResultMatchers.jsonPath("$.code").value(200);
								ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
								/* Request */
								MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
																.post("/products/post")
																.contentType(MediaType.APPLICATION_JSON)
																.content(payload);
								// Act & Assert
								mockMvc
																.perform(requestPayload)
																.andDo(print())
																.andExpectAll(expectedStatus, expectedContentType, expectedMessage, expectedCode);
				}


				@Test
				@DisplayName("Obtener la lista de publicacines de los seguidos")
				void getPostSellersOK() throws Exception {

								/* Matchers */
								ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
								ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
								ResultMatcher expectedMessage = MockMvcResultMatchers.jsonPath("$.user_id").value(1);
								ResultMatcher expectedCode = MockMvcResultMatchers.jsonPath("$.posts").value(new ArrayList<>());
								/* Request */
								MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
																.get("/products/followed/{userId}/list",1);
								// Act & Assert
								mockMvc
																.perform(requestPayload)
																.andDo(print())
																.andExpectAll(expectedStatus, expectedContentType, expectedMessage, expectedCode);
				}

				@Test
				@DisplayName("En caso de que el usuario no exista")
				void getPostSellersNotOk() throws Exception {
								// Arrange

								/* Matchers */
								ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
								ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
								ResultMatcher expectedMessage = MockMvcResultMatchers.jsonPath("$.message").value("The user hasn't being found");
								/* Request */
								MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
																.get("/products/followed/{userId}/list",12);
								// Act & Assert
								mockMvc
																.perform(requestPayload)
																.andDo(print())
																.andExpectAll(expectedStatus, expectedContentType, expectedMessage);
				}

}

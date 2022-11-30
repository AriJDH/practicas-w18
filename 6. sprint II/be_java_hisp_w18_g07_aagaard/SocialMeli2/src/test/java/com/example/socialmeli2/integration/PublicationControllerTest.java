package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.request.PublicationRequest;
import com.example.socialmeli2.dto.response.ErrorResponse;
import com.example.socialmeli2.util.PublicationFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;

@AutoConfigureMockMvc
@SpringBootTest
class PublicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("T-0010 - Integration - User followed seller publications")
    class getUserFollowedPublicationsById {
        @Test
        void whenValidInput_thenReturns200() throws Exception {
            // Arrange
            Integer userId = 1;
            /* Matchers */
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().is2xxSuccessful();
            /* Request */
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .get("/products/followed/{userId}/list", userId);
            // Act & Assert
            mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpectAll(expectedStatus);
        }

        @Test
        void whenUserNotFound_thenReturnErrorResponse() throws Exception {
            // Arrange
            Integer userId = 20;
            /* Expected */
            ErrorResponse errorResponse = new ErrorResponse("No existe usuario con ID: 20", 400);
            String errorJson = objectMapper.writeValueAsString(errorResponse);
            /* Matchers */
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(errorJson);
            ResultMatcher expectedContentType = MockMvcResultMatchers
                    .content().contentType(MediaType.APPLICATION_JSON);
            /* Request */
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .get("/products/followed/{userId}/list", userId);
            // Act & Assert
            mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpectAll(expectedStatus, expectedJson, expectedContentType);
        }
    }

    /**
     * T-0009
     * - Verificar que la creación de una publicación válida se realiza correctamente
     * - Verificar que la creación de una publicación invalida el resuelto correctamente (US-0005)
     */
    @Nested
    @DisplayName("T-0009 - Integration - Create publication")
    class createPublication {

        /**
         * Valid request: Returns a response with a status of OK
         */
        @Test
        void whenValidInput_thenReturns200() throws Exception {
            // Arrange
            /* Expected */
            PublicationRequest publicationRequest = PublicationFactory.getPublicationsRequest();
            String payload = objectMapper.writeValueAsString(publicationRequest);
            /* Matchers */
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().is2xxSuccessful();
            /* Request */
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payload);
            // Act & Assert
            mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpectAll(expectedStatus);
        }

        /**
         * Invalid request: Returns a response with a client error status
         */
        @Test
        void whenInvalidInput_thenReturns400() throws Exception {
            // Arrange
            /* Expected */
            PublicationRequest publicationRequest = PublicationFactory.getPublicationsRequestInvalid();
            String payload = objectMapper.writeValueAsString(publicationRequest);
            /* Matchers */
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().is4xxClientError();
            /* Request */
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payload);
            // Act & Assert
            mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpectAll(expectedStatus);
        }

        /**
         * Invalid request: Returns a body specifying the invalid objects
         */
        @Test
        void whenInvalidInput_thenReturnsErrorValidationListResponse() throws Exception {
            // Arrange
            /* Expected */
            String payload = new String(Files.readAllBytes(
                    ResourceUtils.getFile("classpath:publicationBadRequest.json").toPath()));
            String expectedJsonString = new String(Files.readAllBytes(
                    ResourceUtils.getFile("classpath:publicationBadResponse.json").toPath()));
            /* Matchers */
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expectedJsonString);
            ResultMatcher expectedContentType = MockMvcResultMatchers
                    .content().contentType(MediaType.APPLICATION_JSON);
            /* Request */
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                    .post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payload);
            // Act & Assert
            mockMvc.perform(requestBuilder)
                    .andDo(MockMvcResultHandlers.print())
                    .andExpectAll(expectedJson, expectedContentType);
        }
    }
}

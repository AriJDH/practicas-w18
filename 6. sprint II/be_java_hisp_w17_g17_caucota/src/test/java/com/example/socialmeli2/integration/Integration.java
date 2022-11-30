package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.request.ProductRequest;
import com.example.socialmeli2.dto.request.PublicationRequest;
import com.example.socialmeli2.dto.response.ErrorValidationListResponse;
import com.example.socialmeli2.dto.response.ErrorValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class Integration {

    @Autowired
     MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Nested
    @DisplayName("T-0009 Create Publication Test")
    class createPublicationTest{
        @Test
        @DisplayName("Create a new publication OK")
        void createPublicationOk() throws Exception {
            //Arrange
            PublicationRequest publicationRequest = new PublicationRequest();

            publicationRequest.setUserId(1);

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String caseStartDate = dateFormat.format(LocalDateTime.now());
            LocalDate localdatetime = LocalDate.parse(caseStartDate, dateFormat);

            publicationRequest.setDate(localdatetime);

            ProductRequest productRequest = new ProductRequest();
            productRequest.setId(1);
            productRequest.setName("Silla Gamer");
            productRequest.setType("Gamer");
            productRequest.setBrand("Racer");
            productRequest.setColor("Rojo");
            productRequest.setNotes("Special Edition");
            publicationRequest.setProductRequest(productRequest);

            publicationRequest.setCategory(2);
            publicationRequest.setPrice(23.45);


            String publicationRequestString = objectMapper.writeValueAsString(publicationRequest);
            String payLoad = objectMapper.writeValueAsString(publicationRequest);
            /* Matchers */
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(publicationRequestString);
            ResultMatcher expectedContentType = MockMvcResultMatchers
                    .content()
                    .contentType(MediaType.APPLICATION_JSON);
            /* Request */

            MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                    .post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payLoad);
            //Act & Assert
            mockMvc
                    .perform(requestPayload)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedJson, expectedContentType);
        }
        @Test
        @DisplayName("Create a new publication FAIL")
        void createPublicationNoOk() throws Exception {
            //Arrange
            PublicationRequest publicationRequest = new PublicationRequest();

            publicationRequest.setUserId(1);

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String caseStartDate = dateFormat.format(LocalDateTime.now());
            LocalDate localdatetime = LocalDate.parse(caseStartDate, dateFormat);

            publicationRequest.setDate(null);

            ProductRequest productRequest = new ProductRequest();
            productRequest.setId(2);
            productRequest.setName("Silla Gamer");
            productRequest.setType("Gamer");
            productRequest.setBrand("Racer");
            productRequest.setColor("Rojo");
            productRequest.setNotes("Special Edition");
            publicationRequest.setProductRequest(productRequest);

            publicationRequest.setCategory(2);
            publicationRequest.setPrice(23.45);

            String publicationRequestString = objectMapper.writeValueAsString(publicationRequest);
            String payLoad = objectMapper.writeValueAsString(publicationRequest);
            /* Matchers */
            ResultMatcher expectedContentType = MockMvcResultMatchers
                    .content()
                    .contentType(MediaType.APPLICATION_JSON);
            /* Request */

            MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                    .post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payLoad);
            //Act & Assert
            mockMvc
                    .perform(requestPayload)
                    .andDo(print())
                    .andExpectAll(expectedContentType);
        }


        }
}

package com.example.socialmeli2.controller;

import com.example.socialmeli2.dto.request.ProductRequest;
import com.example.socialmeli2.dto.request.PublicationRequest;
import com.example.socialmeli2.repository.IPublicationRepository;
import com.example.socialmeli2.repository.IUserRepository;
import com.example.socialmeli2.repository.PublicationRepositoryImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PublicationControllerTest {


    @DisplayName("Testing /products/post")
    @Nested
    class ProductsPost{
        @Autowired
        private MockMvc mockMvc;

        ProductRequest validProductRequest;
        ObjectWriter ow;
        private IPublicationRepository publicationRepository;

        @BeforeEach
        void initialize(){
            this.publicationRepository = new PublicationRepositoryImpl();

            this.validProductRequest = new ProductRequest(10, "PowerStation 2", "console","Nisuta","black","poderoso");
            this.ow = new ObjectMapper()
                    .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                    .writer()
                    .withDefaultPrettyPrinter();

        }

        @DisplayName("Succesfull Post")
        @Test
        void validPublicationPost()throws Exception{
//            PublicationRequest requestValido = new PublicationRequest(400, LocalDate.of(2022,11,11),validProductRequest,20,400.0);

            String jsonValido = "{\n" +
                    "    \"user_id\": 4,\n" +
                    "    \"date\": \"29-04-2021\",\n" +
                    "    \"product\": {\n" +
                    "        \"product_id\": 3,\n" +
                    "        \"product_name\": \"Teclado\",\n" +
                    "        \"type\": \"Gamer\",\n" +
                    "        \"brand\": \"Racer\",\n" +
                    "        \"color\": \"Yelow\",\n" +
                    "        \"notes\": \"Special Edition\"\n" +
                    "    },\n" +
                    "    \"category\": 10,\n" +
                    "    \"price\": 1500.50\n" +
                    "}";

            MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonValido)
                    )
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
        }

        @DisplayName("Validation Error")
        @Test
        void invalidPublicationPost() throws Exception {
            PublicationRequest requestInvalido = new PublicationRequest(-1, null,validProductRequest,20,400.0);

            String jsonInvalido = "{\n" +
                    "    \"user_id\": 4,\n" +
                    "    \"product\": {\n" +
                    "        \"product_id\": 3,\n" +
                    "        \"product_name\": \"Teclado\",\n" +
                    "        \"type\": \"Gamer\",\n" +
                    "        \"brand\": \"Racer\",\n" +
                    "        \"color\": \"Yelow\",\n" +
                    "        \"notes\": \"Special Edition\"\n" +
                    "    },\n" +
                    "    \"category\": 10,\n" +
                    "}";
            MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonInvalido)
                    )
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andReturn();


        }
    }


}
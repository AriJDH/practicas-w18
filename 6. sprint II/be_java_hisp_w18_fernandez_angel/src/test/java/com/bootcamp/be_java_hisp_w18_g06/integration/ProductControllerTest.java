package com.bootcamp.be_java_hisp_w18_g06.integration;


import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.exception.ExceptionValidResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.bootcamp.be_java_hisp_w18_g06.utils.PostFactory.getPostDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

   @Autowired
   MockMvc mockMvc;

    @Nested
    class saveTests{
        @Test
        void saveOkTest() throws Exception {
            PostDTO requestPostDto=getPostDto(2);


            String payload= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(requestPostDto);

            mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payload))
                    .andDo(print())
                    .andExpect(status().isOk());
        }
       @Test
       void saveExceptionTest() throws Exception {
          List<String> messages=new ArrayList<>();
          messages.add("Id must be greater than 0");
          ExceptionValidResponseDTO validResponseDTO=new ExceptionValidResponseDTO(messages,400, LocalDate.now());

          PostDTO requestPostDto=getPostDto(-2);



          String payload= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(requestPostDto);
          String validDtoJson= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(validResponseDTO);

         MvcResult result= mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(payload))
                  .andDo(print())
                  .andExpect(status().isBadRequest())
                 .andExpect(content().contentType("application/json"))
                 .andReturn();
         assertEquals(validDtoJson,result.getResponse().getContentAsString());
       }
    }


}
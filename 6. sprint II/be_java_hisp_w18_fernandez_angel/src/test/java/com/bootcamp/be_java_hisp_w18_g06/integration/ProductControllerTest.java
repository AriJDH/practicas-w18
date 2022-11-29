package com.bootcamp.be_java_hisp_w18_g06.integration;


import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.exception.ExceptionResponseDto;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.exception.ExceptionValidResponseDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
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

import static com.bootcamp.be_java_hisp_w18_g06.repository.imp.UserRepository.getUsers;
import static com.bootcamp.be_java_hisp_w18_g06.utils.PostFactory.getPostDto;
import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.getUserRandom;
import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.getUserWithFollowersListAndPosts;
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
    @Nested
   class findAllByUserTests{
       @Test
       public void findAllByUserOkTest() throws Exception {

          List<User>users=getUsers();
          User seller=getUserWithFollowersListAndPosts("Marco");
          User buyer=users.get(0);
          buyer.setFollowed(Collections.singletonList(seller));
          List<PostDTO>expectList=getPostDto();
          String payload= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(buyer);
          String validDtoJson= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(expectList);

          MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/products//followed/{userId}/list",buyer.getUser_id())
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(payload))
                  .andDo(print())
                  .andExpect(status().isOk())
                  .andExpect(content().contentType("application/json"))
                  .andReturn();
          assertEquals(validDtoJson,result.getResponse().getContentAsString());

       }
       @Test
       public void findAllByUserExceptionTest() throws Exception {


          User buyer=getUserRandom("Juan");
          ExceptionResponseDto validResponseDTO=new ExceptionResponseDto("The user id"+buyer.getUser_id()+ " does not exist");


          String payload= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(buyer);
          String validDtoJson= new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(validResponseDTO);

          //mock

          MvcResult result= mockMvc.perform(MockMvcRequestBuilders.get("/products//followed/{userId}/list",buyer.getUser_id())
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
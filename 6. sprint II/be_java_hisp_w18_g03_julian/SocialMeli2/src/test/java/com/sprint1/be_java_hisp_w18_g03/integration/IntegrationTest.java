package com.sprint1.be_java_hisp_w18_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint1.be_java_hisp_w18_g03.dto.request.RequestPostDTO;
import com.sprint1.be_java_hisp_w18_g03.dto.response.ResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.sprint1.be_java_hisp_w18_g03.utils.PostFactory.getRequestPostDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    /* US 0001 */
    @Test
    @DisplayName("US0001 Integracion follow - usuario no tiene post")
    void followTestNoPost() throws Exception{
        int userId = 1;
        int userIdToFollow = 2;

        mockMvc.perform(post("/users//{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User has not posts"));
    }

    /* US 0001 */
    @Test
    @DisplayName("US0001 Integracion follow - usuario no encontrado")
    void followTestNotFound() throws Exception{
        int userId = 1;
        int userIdToFollow = 7;

        mockMvc.perform(post("/users//{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The user has not being found"));
    }

    /* US 0001 */
    @Test
    @DisplayName("US0001 Integracion follow - usuario no encontrado")
    void followTestNotFollowToHimSelf() throws Exception{
        int userId = 1;
        int userIdToFollow = 1;

        mockMvc.perform(post("/users//{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The user can't follow to himself"));
    }

    /* US 0005 */
    @Test
    @DisplayName("US0005 Integracon crear un post - OK")
    void createPostTest() throws Exception{

        RequestPostDTO postDTO = getRequestPostDto(1);
        ResponseDTO responseDTO = new ResponseDTO("Post added successfully", 201);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .findAndRegisterModules()
                .writer();

        String payloadDto = writer.writeValueAsString(postDTO);
        String expectedDto = writer.writeValueAsString(responseDTO);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadDto))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedDto, mvcResult.getResponse().getContentAsString());
    }
}

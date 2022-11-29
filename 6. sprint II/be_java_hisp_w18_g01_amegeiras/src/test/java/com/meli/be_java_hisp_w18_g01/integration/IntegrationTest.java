package com.meli.be_java_hisp_w18_g01.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
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
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US 0002 - Test GET del count de followers del usuario")
    void test1 () throws Exception {
        /* Arrange */

        UserFollowersCountDTO userFollowersCountDTO = new UserFollowersCountDTO(1L,"lucas",0);
        String userFollowersCountDTOString = new ObjectMapper().writeValueAsString(userFollowersCountDTO);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(userFollowersCountDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", 1);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("US 0005 - Test POST de un product")
    void test2 () throws Exception {
        /* Arrange */
        ProductDTO productDTO = new ProductDTO(5L,"Auto","Tipo 1","Ferrari","Verde","Esta todo chocado");
        PostDTO postDTO  = new PostDTO(1L,"22-02-1997",productDTO,22,9999.99);
        ResponseDTO responseDTO = new ResponseDTO(200, "operación exitosa");

        String responseDTOString = new ObjectMapper().writeValueAsString(responseDTO);
        String payload = new ObjectMapper().writeValueAsString(postDTO);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(responseDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("US 0001 - Test POST de seguir a un usuario que no es vendedor")
    void test3 () throws Exception {
        /* Arrange */

        ResponseDTO errorDTO = new ResponseDTO(400,"No puede seguir al usuario 3 porque no es un vendedor.");

        String errorDTOString = new ObjectMapper().writeValueAsString(errorDTO);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(errorDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userId}",2,3);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("US 0001 - Test POST de seguir a un usuario que no existe")
    void test4 () throws Exception {
        /* Arrange */

        ResponseDTO errorDTO = new ResponseDTO(404,"El usuario 4 no existe.");

        String errorDTOString = new ObjectMapper().writeValueAsString(errorDTO);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(errorDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userId}",2,4);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }



    @Test
    @DisplayName("US 0001 - Test POST de seguirse a si mismo")
    void test5 () throws Exception {
        /* Arrange */

        ResponseDTO errorDTO = new ResponseDTO(400,"Un usuario no puede seguir a sí mismo.");

        String errorDTOString = new ObjectMapper().writeValueAsString(errorDTO);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(errorDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userId}",1,1);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @DisplayName("US 0001 - Test POST de seguir a alguien que ya sigue")
    void test6 () throws Exception {
        /* Arrange */

        ResponseDTO errorDTO = new ResponseDTO(409,"El usuario 5 ya sigue al usuario 6");

        String errorDTOString = new ObjectMapper().writeValueAsString(errorDTO);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isConflict();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(errorDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userId}",5,6);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }
}



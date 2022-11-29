package com.mercadolibre.socialmeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.ResponseDto;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IUserRepository userRepository;

    @Test
    void unfollowTest() throws Exception{
        //Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 4;
        ResponseDto responseDtoJson = new ResponseDto("El usuario 1 dejó de seguir al usuario 4", 200);

        //Lo convierte a json
        String response = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(responseDtoJson);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.jsonPath("$.messages").value(responseDtoJson.getMessages());
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                .contentType(MediaType.APPLICATION_JSON);

        //Act and assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }

    @Test
    void getCountTest() throws Exception{
        //Arrange
        Integer userId = 3;
        SellerFollowerCountDtoRes sellerFollowerCountDtoRes = new SellerFollowerCountDtoRes(3,"LaOfertaPerfecta",1);

        //Lo convierte a json
        String response = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(sellerFollowerCountDtoRes);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(response);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/users/{userId}/followers/count", userId)
                .contentType(MediaType.APPLICATION_JSON);

        //Act and assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }

    @Test
    void addPostTest() throws Exception{
        //Arrange
        ProductDto productDto = new ProductDto(20, "Silla Gamer", "Gamer", "Racer", "Red", "Special Edition");
        PostDtoReq postDtoReq = new PostDtoReq(3, LocalDate.now(), productDto,100,1500.5);
        ResponseDto responseDtoJson = new ResponseDto("Post creado correctamente", 201);

        //Lo convierte a json
        String response = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(responseDtoJson);
        String payload = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(postDtoReq);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedJson   = MockMvcResultMatchers.jsonPath("$.messages").value(responseDtoJson.getMessages());
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act and assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }

    @Test
    void followTest() throws Exception{
        //Arrange
        Integer userId = 1;
        Integer userIdToFollow = 4;
        ResponseDto responseDtoJson = new ResponseDto("El usuario id 1 ya sigue al usuario id 4", 400);

        //Lo convierte a json
        String response = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(responseDtoJson);

        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedJson   = MockMvcResultMatchers.jsonPath("$.messages").value(responseDtoJson.getMessages());
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                .contentType(MediaType.APPLICATION_JSON);

        //Act and assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }

    /*
    * @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ResponseDto> follow(@PathVariable Integer userId,
                                         @PathVariable Integer userIdToFollow){
        ResponseDto res = new ResponseDto(userService.follow(userId, userIdToFollow), 200);
        return ResponseEntity.ok(res);
    }*/




}

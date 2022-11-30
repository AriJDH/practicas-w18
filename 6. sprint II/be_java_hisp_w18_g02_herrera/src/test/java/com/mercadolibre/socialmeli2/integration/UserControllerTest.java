package com.mercadolibre.socialmeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.ResponseDto;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli2.dto.response.UserDtoRes;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import com.mercadolibre.socialmeli2.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setup() {
        userRepository.setUsers(userRepository.loadUsers());
    }

    @Test
    @DisplayName("US0001 POST /users/{userId}/follow/{userIdToFollow} (Happy path)")
    void followIntegrationTestOk() throws Exception {
        // Arrange
        ResponseDto responseDto = new ResponseDto("El usuario 2 ahora sigue al usuario 4", 200);

        mockMvc.perform(MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollow}", 2, 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(responseDto.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200));
    }

    @Test
    @DisplayName("US0001 POST /users/{userId}/follow/{userIdToFollow} (Sad path: Can't follow yourself)")
    void followIntegrationTestSad() throws Exception {
        // Arrange
        ResponseDto responseDto = new ResponseDto("No es posible seguirse a si mismo.", 400);

        mockMvc.perform(MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollow}", 4, 4))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(responseDto.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400));
    }

    @Test
    @DisplayName("US0002 GET /users/{userId}/followers/count (Happy path)")
    void getCountIntegrationTestOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("LaOfertaPerfecta"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(1));
    }

    @Test
    @DisplayName("US0002 GET /users/{userId}/followers/count (Sad path: User doesn't exist)")
    void getCountIntegrationTestSad() throws Exception {
        // Arrange
        ResponseDto responseDto = new ResponseDto("No se pudo encontrar al usuario 99", 400);

        // Matchers
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 99))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(responseDto.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400));
    }

    @Test
    @DisplayName("US0003 GET /users/{userId}/followers/list (Happy path)")
    void getFollowersIntegrationTestOk() throws Exception {
        // Arrange
        UserDtoRes u1Dto = new UserDtoRes(1, "Juan Perez");
        List<UserDtoRes> expectedFollowers = Arrays.asList(u1Dto);
        SellerFollowerListDtoRes expected = new SellerFollowerListDtoRes(4, "MotociclosSA", expectedFollowers);
        String expectedJson = new ObjectMapper().writeValueAsString(expected);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    @DisplayName("US0005 POST /products/post (Happy Path)")
    void addPostIntTestOk() throws Exception {
        // Arrange
        ResponseDto expectedDto = new ResponseDto("Post creado correctamente", 201);

        ProductDto productDto = new ProductDto(1, "Sillar Gamer", "Gamer",
                "Racer", "RedBlack", "Special Edition");
        PostDtoReq payloadDto = new PostDtoReq(3, LocalDate.now(), productDto, 100, 1500D);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        ObjectWriter writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);

        // Matchers
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(expectedDto.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(201))
                .andReturn();
    }

    @Test
    @DisplayName("US0005 POST /products/post (Sad Path: User not found)")
    void addPostIntTestSadUserNotFound() throws Exception {
        // Arrange
        ResponseDto expectedDto = new ResponseDto("El usuario 99 no existe", 400);

        ProductDto productDto = new ProductDto(1, "Sillar Gamer", "Gamer",
                "Racer", "RedBlack", "Special Edition");
        PostDtoReq payloadDto = new PostDtoReq(99, LocalDate.now(), productDto, 100, 1500D);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        ObjectWriter writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);

        // Matchers
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(expectedDto.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
                .andReturn();
    }
}

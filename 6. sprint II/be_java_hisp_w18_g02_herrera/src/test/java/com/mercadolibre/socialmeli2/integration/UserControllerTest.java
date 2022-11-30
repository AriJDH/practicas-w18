package com.mercadolibre.socialmeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.*;
import com.mercadolibre.socialmeli2.repository.UserRepository;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.hamcrest.Matchers;
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
        userRepository.setUsers(UserFactory.loadUsers());
    }

    @Test
    @DisplayName("US0001 POST /users/{userId}/follow/{userIdToFollow} (Happy path)")
    void followIntegrationTestOk() throws Exception {
        // Arrange
        ResponseDto responseDto = new ResponseDto("El usuario 2 ahora sigue al usuario 4", 200);

        // Act & Assert
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

        // Act & Assert
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

        // Act & Assert
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
    @DisplayName("US0004 GET /users/{userId}/followed/list (Happy path: without order)")
    void getFollowedIntegrationTestOk() throws Exception {
        // Arrange
        UserDtoRes u3Dto = new UserDtoRes(3, "LaOfertaPerfecta");
        UserDtoRes u4Dto = new UserDtoRes(4, "MotociclosSA");
        List<UserDtoRes> expectedFollowed = Arrays.asList(u4Dto, u3Dto);
        UserFollowedListDtoRes expected = new UserFollowedListDtoRes(1, "Juan Perez", expectedFollowed);
        String expectedJson = new ObjectMapper().writeValueAsString(expected);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    @DisplayName("US0004 GET /users/{userId}/followed/list (Happy path: with order asc)")
    void getFollowedOrderedAscIntTestOk() throws Exception {
        // Arrange
        userRepository.setUsers(UserFactory.loadAbcUsers());

        List<UserDtoRes> expectedFollowed = UserFactory.getUsersListDto(null);
        UserFollowedListDtoRes expected = new UserFollowedListDtoRes(1, "Juan", expectedFollowed);
        String expectedJson = new ObjectMapper().writeValueAsString(expected);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name").value("Alberto"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_name").value("Beto"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[2].user_name").value("Camila"));
    }

    @Test
    @DisplayName("US0004 GET /users/{userId}/followed/list (Happy path: with order desc)")
    void getFollowedOrderedDescIntTestOk() throws Exception {
        // Arrange
        userRepository.setUsers(UserFactory.loadAbcUsers());

        List<UserDtoRes> expectedFollowed = UserFactory.getUsersListDto(null);
        UserFollowedListDtoRes expected = new UserFollowedListDtoRes(1, "Juan", expectedFollowed);
        String expectedJson = new ObjectMapper().writeValueAsString(expected);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                    .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name").value("Camila"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[1].user_name").value("Beto"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[2].user_name").value("Alberto"));
    }

    @Test
    @DisplayName("US0004 GET /users/{userId}/followed/list (Sad path: Invalid order)")
    void getFollowedInvalidOrder() throws Exception {
        // Arrange
        userRepository.setUsers(UserFactory.loadAbcUsers());

        ResponseDto expected = new ResponseDto("El tipo de ordenamiento no es válido.", 400);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                    .param("order", "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(expected.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400));
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

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(expectedDto.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(201));
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

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(expectedDto.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400));
    }

    @Test
    @DisplayName("US0005 POST /products/post (Sad Path: Invalid Arguments: color)")
    void addPostIntTestSadInvalidArguments() throws Exception {
        // Arrange
        ResponseDto expectedDto = new ResponseDto(
                "El campo no puede poseer caracteres especiales: color", 400);

        ProductDto productDto = new ProductDto(1, "Sillar Gamer", "Gamer",
                "Racer", "Red Black", "Special Edition");
        PostDtoReq payloadDto = new PostDtoReq(3, LocalDate.now(), productDto, 100, 1500D);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        ObjectWriter writer = mapper
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(payloadDto);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.messages").value(expectedDto.getMessages()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400));
    }

    @Test
    @DisplayName("US0006 GET /products/followed/{userId}/list (Happy Path: fields)")
    void getRecentPostIntTestOk() throws Exception {
        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].user_id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].post_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].category").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].price").value(15999.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].post_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].category").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].price").value(15.5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].product.product_id").value(1));
    }

    @Test
    @DisplayName("US0006 GET /products/followed/{userId}/list (Happy Path: correctness)")
    void getRecentPostIntTestTwoWeeksOk() throws Exception {
        // Arrange
        userRepository.setUsers(UserFactory.loadUsersWithPosts());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.posts[*].post_id")
                        .value(Matchers.containsInAnyOrder(1, 2, 3, 4, 5)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.posts[*].category")
                        .value(Matchers.containsInAnyOrder(1, 2, 3, 4, 5)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.posts[*].price")
                        .value(Matchers.containsInAnyOrder(15.5, 15999.99, 7000D, 5999D, 200D)));
    }
}

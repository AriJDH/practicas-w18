package com.mercadolibre.socialmeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.ResponseDto;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli2.dto.response.UserDtoRes;
import com.mercadolibre.socialmeli2.dto.response.UserFollowedListDtoRes;
import com.mercadolibre.socialmeli2.entity.User;
import com.mercadolibre.socialmeli2.repository.UserRepository;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Test
    void testAddPost () throws Exception {
        // Arrange
        userRepository.setUsers(UserFactory.loadUsers());
        ProductDto productDto = new ProductDto(1, "Producto 1", "Tipo1","Marca 1","Rojo","Nota 1");
        PostDtoReq post = new PostDtoReq(1, LocalDate.now(),productDto,1,1000D);
        ResponseDto response = new ResponseDto("Post creado correctamente",200);
        String expected = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(response);
        String payload = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson =  MockMvcResultMatchers.jsonPath("$.messages").value(response.getMessages());
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload =  MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        // Act & Assert
        mockMvc.perform(requestPayload).andDo(print()).
                andExpectAll(expectedStatus,expectedJson,expectedContentType);

    }


    @Test
    void testGetFollowed () throws Exception {
        // Arrange
        userRepository.setUsers(UserFactory.loadUsers());
        Map<Integer, User> userList = UserFactory.loadUsers();
        List<UserDtoRes> userDtoResList  = userList.get(1).getFollowed().stream().map(u->new UserDtoRes(u.getId(),u.getName())).collect(Collectors.toList());
        UserFollowedListDtoRes userFollowedListDtoRes = new UserFollowedListDtoRes(1,userList.get(1).getName(),userDtoResList);
        ResponseEntity<UserFollowedListDtoRes> response = ResponseEntity.ok(userFollowedListDtoRes);
        String expected = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(response.getBody());

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson =  MockMvcResultMatchers.content().json(expected);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload =  MockMvcRequestBuilders
                .get("/users/1/followed/list");

        // Act & Assert
        MvcResult mvcResult = mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType)
                .andReturn();
    }
}

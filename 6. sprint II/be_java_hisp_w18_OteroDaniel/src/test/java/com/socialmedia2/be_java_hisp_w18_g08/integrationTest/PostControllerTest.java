package com.socialmedia2.be_java_hisp_w18_g08.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmedia2.be_java_hisp_w18_g08.dto.ProductDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.request.PostDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ResponseMessasgeDto;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Product;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.utils.Repositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private PostRepositoryImp postRepo;
    @Autowired
    private UserRepositoryImp userRepo;

    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @BeforeEach
    void setUp() {
        Repositories.resetRepos(postRepo, userRepo);
    }

    @Test
    @DisplayName("T-0009 - Creación exitosa de un post")
    void creatPostOk() throws Exception {
        //Arrange
        PostDtoReq newPost = getPostDtoReq();
        String payload = objectMapper.writeValueAsString(newPost);
        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //Request
        MockHttpServletRequestBuilder requestPayload =
                MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload);
        //Act & Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);
    }

    @Test
    @DisplayName("T-0010 - Obtener lista de los post de vendedores que sigo correctamente")
    public void getRecentPostsFromFollowed() throws Exception {
        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.get("/products/followed/1/list");
        //Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedContentType);
    }

    private PostDtoReq getPostDtoReq() {
        ProductDto product = new ProductDto(1, "Product1", "Type1", "Brand1", "Color1", "Notes1");
        PostDtoReq newPost = new PostDtoReq(5, product, 1, 1500.50, LocalDate.now());
        return newPost;
    }

}

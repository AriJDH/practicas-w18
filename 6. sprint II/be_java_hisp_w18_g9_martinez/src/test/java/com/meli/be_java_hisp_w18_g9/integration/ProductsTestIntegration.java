package com.meli.be_java_hisp_w18_g9.integration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductsTestIntegration {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private IUserRepository userRepository;
    static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());


    @Test
    @DisplayName("Test uri: /products/post ** user not found **")
    void testIntegracionCreatePostUserNotFound() throws Exception {
        /* Arrange */
        PostDtoRequest postDtoTestRequest = new PostDtoRequest(1, 1, LocalDate.now(),
                new Product(3, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"),
                2, 1500.20);
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        String payload = mapper.writeValueAsString(postDtoTestRequest);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andExpectAll(
                        result -> assertEquals("User with id 1 not found",
                                result.getResolvedException().getMessage()),
                        expectedStatus);

    }

    @Test
    @DisplayName("Test uri: /products/post ** user found **")
    void testIntegracionCreatePost() throws Exception {
        /* Arrange */
        User userTestExpect =
                new User(1, "Janeth", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoTestRequest =
                new PostDtoRequest(1, 1, LocalDate.now(), product, 1, 10.0);

        List<Product> products = new ArrayList<>();
        products.add(product);
        userTestExpect.setProducts(products);


        when(userRepository.findById(1)).thenReturn(Optional.of(userTestExpect));
        String payload = mapper.writeValueAsString(postDtoTestRequest);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Test uri: /products/post ** validation of required field product **")
    void testIntegracionCreatePostvalidationFieldsPrice() throws Exception {
        /* Arrange */
        User userTestExpect =
                new User(1, "Janeth", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoTestRequest =
                new PostDtoRequest(1, 1, LocalDate.now(), product, 1, null);

        List<Product> products = new ArrayList<>();
        products.add(product);
        userTestExpect.setProducts(products);

        when(userRepository.findById(1)).thenReturn(Optional.of(userTestExpect));
        String payload = mapper.writeValueAsString(postDtoTestRequest);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContent =
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andExpectAll(
                        expectedStatus);


    }

    @Test
    @DisplayName("Test uri: /products/post ** validation of required field product **")
    void testIntegracionCreatePostvalidationFieldsProduct() throws Exception {
        /* Arrange */
        User userTestExpect =
                new User(1, "Janeth", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoTestRequest =
                new PostDtoRequest(1, 1, LocalDate.now(), product, 1, 10.500);


        when(userRepository.findById(1)).thenReturn(Optional.of(userTestExpect));
        String payload = mapper.writeValueAsString(postDtoTestRequest);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isForbidden();
        ResultMatcher expectedMessage = MockMvcResultMatchers.jsonPath("$.message")
                .value("Product not associated with user");
        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);
        // Act & Assert
        mockMvc
                .perform(requestPayload)
                .andExpectAll(
                        expectedStatus,
                        expectedMessage
                );
    }

}

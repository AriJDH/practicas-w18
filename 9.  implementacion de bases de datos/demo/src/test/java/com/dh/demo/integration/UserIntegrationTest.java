package com.dh.demo.integration;

import com.dh.demo.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserIntegrationTest extends IntegrationTest{

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository repository;

    @Test
    @Order(1)
    @DisplayName("demo test users delete")
    void demoTestUsers2 () throws Exception {
        // Arrange
        String expectedJson = "{}";

        repository.deleteAll();

        ResultMatcher expectedStatus  = status().isOk();
        ResultMatcher expectedContent = content().json(expectedJson);

        MockHttpServletRequestBuilder request = get("/users");

        // Act & Assert
        mockMvc.perform(request)
          .andDo(print())
          .andExpectAll(
            expectedStatus,
            expectedContent
          );
    }

    @Test
    @Order(2)
    @DisplayName("demo test users")
    void demoTestUsers1 () throws Exception {
        // Arrange
        String expectedJson = "{}";

        ResultMatcher expectedStatus  = status().isOk();
        ResultMatcher expectedContent = content().json(expectedJson);

        MockHttpServletRequestBuilder request = get("/users");

        // Act & Assert
        mockMvc.perform(request)
          .andDo(print())
          .andExpectAll(
            expectedStatus,
            expectedContent
          );
    }


}

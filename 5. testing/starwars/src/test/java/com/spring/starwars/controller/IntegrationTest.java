package com.spring.starwars.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test1() throws Exception {
        /*[
        {
            "name": "Luke Skywalker",
                "height": 172,
                "mass": 77,
                "gender": "male",
                "homeworld": "Tatooine",
                "species": "Human"
        }
]*/
        mockMvc.perform(MockMvcRequestBuilders.get("/figuren")
                .param("name", "Luke"))
                .andDo(print())
                .andExpectAll(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

}

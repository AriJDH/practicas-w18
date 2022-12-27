package com.example.frescos.integration;

import com.example.frescos.dtos.BatchForStockDTO;
import com.example.frescos.dtos.SectionDTO;
import com.example.frescos.dtos.WarehouseDTO;
import com.example.frescos.utils.LoginManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static String agentToken;

    private void loginAsAgent() throws Exception {
        agentToken=  LoginManager.loginAsAgent(mockMvc);
    }
    @Test
    @Rollback
    @DisplayName("REQ3 - Consultar un producto en stock en el warehouse")
    public void getListProductOk() throws Exception {
        //Arrange
        loginAsAgent();
        Integer sectionCode = 2;
        Long warehoseCode = 2L;
        Long productId = 10L;
        List<BatchForStockDTO> batches = new ArrayList<>();

        SectionDTO sectionDTO = new SectionDTO(sectionCode, warehoseCode);
        WarehouseDTO warehouseExpect = new WarehouseDTO(sectionDTO, productId, batches);
        String expect = objectMapper.writeValueAsString(warehouseExpect);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/{idProduct}/batch/list/", productId)
                .param("order", "L")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @Rollback
    @DisplayName("REQ3 - Consultar un producto con un order null")
    public void getListProductOrderNull() throws Exception {
        ///Arrange
        loginAsAgent();
        Integer sectionCode = 2;
        Long warehoseCode = 2L;
        Long productId = 10L;
        List<BatchForStockDTO> batches = new ArrayList<>();

        SectionDTO sectionDTO = new SectionDTO(sectionCode, warehoseCode);
        WarehouseDTO warehouseExpect = new WarehouseDTO(sectionDTO, productId, batches);
        String expect = objectMapper.writeValueAsString(warehouseExpect);

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/{idProduct}/batch/list/", productId)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @Rollback
    @DisplayName("REQ3 - Consultar un producto con un order inválido")
    public void getListProductOrderBad() throws Exception {
        //Arrange
        loginAsAgent();
        Long productId = 10L;

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/{idProduct}/batch/list/", productId)
                .param("order", "Inválido")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }
}

package com.example.frescos.integration;

import com.example.frescos.config.LoadDbScript;
import com.example.frescos.controller.SessionController;
import com.example.frescos.dtos.BatchResponseDTO;
import com.example.frescos.dtos.response.BatchStockDTO;
import com.example.frescos.repository.ApplicationUserRepository;
import com.example.frescos.utils.LoginManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BatchIntegrationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    private static String agentToken;
    @Autowired
    private LoadDbScript loadDbScript;

    private static SessionController sessionController = new SessionController();

    private void loginAsAgent() throws Exception {
        agentToken = LoginManager.loginAsAgent(mockMvc);
    }

    // with 3.0 (or with 2.10 as alternative)
    ObjectMapper mapper = JsonMapper.builder() // or different mapper for other format
            .addModule(new ParameterNamesModule())
            .addModule(new Jdk8Module())
            .addModule(new JavaTimeModule())
            // and possibly other configuration, modules, then:
            .build();

    @Test
    @Rollback
    @DisplayName("Vencimiento entre el dia actual y hasta 5 dias en el futuro")
    public void getAllBatches() throws Exception {


        /* Arrange */
        loginAsAgent();
        BatchResponseDTO batchForStockDTO1 = new BatchResponseDTO(16L, 4L, 1, LocalDate.now(), 10);
        BatchResponseDTO batchForStockDTO2 = new BatchResponseDTO(5L, 5L, 1, LocalDate.now().plusDays(5), 807);

        List<BatchResponseDTO> batches = List.of(batchForStockDTO1,batchForStockDTO2);
        BatchStockDTO batchStockDTO = new BatchStockDTO(batches);

        String responseDTOString = mapper.writeValueAsString(batchStockDTO);


        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 5)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }
    @Test
    @Rollback
        @DisplayName("Vencimiento entre el dia actual y hasta 6 dias en el futuro de la categoría fresco ordenados por fecha descendente")
    public void getAllBatchesOrderByDescendingDate() throws Exception {
        /* Arrange */
        loginAsAgent();

        BatchResponseDTO batchForStockDTO1 = new BatchResponseDTO(16L, 4L, 1, LocalDate.now(), 10);
        BatchResponseDTO batchForStockDTO2 = new BatchResponseDTO(5L, 5L, 1, LocalDate.now().plusDays(5), 807);
        BatchResponseDTO batchForStockDTO3 = new BatchResponseDTO(6L, 6L, 1, LocalDate.now().plusDays(6), 1201);

        List<BatchResponseDTO> batches = List.of(batchForStockDTO1,batchForStockDTO2,batchForStockDTO3);
        BatchStockDTO batchStockDTO = new BatchStockDTO(batches);

        String responseDTOString = mapper.writeValueAsString(batchStockDTO);


        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 6).param("category","RF").param("order","date_desc")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @Rollback
    @DisplayName("Vencimiento entre el dia actual y hasta 6 dias en el futuro de la categoría refrigerado ordenados por fecha ascendente")
    public void getAllBatchesOrderByAscendingDateCool() throws Exception {
        /* Arrange */
        loginAsAgent();
        BatchResponseDTO batchForStockDTO1 = new BatchResponseDTO(16L, 4L, 1, LocalDate.now(), 10);
        BatchResponseDTO batchForStockDTO2 = new BatchResponseDTO(5L, 5L, 1, LocalDate.now().plusDays(5), 807);
        BatchResponseDTO batchForStockDTO3 = new BatchResponseDTO(6L, 6L, 1, LocalDate.now().plusDays(6), 1201);

        List<BatchResponseDTO> batches = List.of(batchForStockDTO1,batchForStockDTO2,batchForStockDTO3);
        BatchStockDTO batchStockDTO = new BatchStockDTO(batches);

        String responseDTOString = mapper.writeValueAsString(batchStockDTO);


        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 6).param("category","RF").param("order","date_asc")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @Rollback
        @DisplayName("Vencimiento entre el dia actual y hasta 6 dias en el futuro de la categoría fresco ordenados por fecha ascendente")
    public void getAllBatchesOrderByAscendingDateFresh() throws Exception {
        /* Arrange */
        loginAsAgent();

        BatchResponseDTO batchForStockDTO1 = new BatchResponseDTO(1L, 1L, 0, LocalDate.now().plusDays(30), 500);
        BatchResponseDTO batchForStockDTO2 = new BatchResponseDTO(2L, 2L, 0, LocalDate.now().plusDays(30), 2000);
        BatchResponseDTO batchForStockDTO3 = new BatchResponseDTO(3L, 3L, 0, LocalDate.now().plusDays(30), 300);

        List<BatchResponseDTO> batches = List.of(batchForStockDTO1,batchForStockDTO2,batchForStockDTO3);
        BatchStockDTO batchStockDTO = new BatchStockDTO(batches);

        String responseDTOString = mapper.writeValueAsString(batchStockDTO);


        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 30).param("category","FS").param("order","date_asc")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @Rollback
        @DisplayName("Vencimiento entre el dia actual y hasta 9 dias en el futuro de la categoría congelado ordenados por fecha descendente")
    public void getAllBatchesOrderByAscendingDateFrozen() throws Exception {
        /* Arrange */
        loginAsAgent();

        BatchResponseDTO batchForStockDTO1 = new BatchResponseDTO(7L, 7L, 2, LocalDate.now().plusDays(7), 9990);
        BatchResponseDTO batchForStockDTO2 = new BatchResponseDTO(8L, 8L, 2, LocalDate.now().plusDays(8), 2776);
        BatchResponseDTO batchForStockDTO3 = new BatchResponseDTO(9L, 9L, 2, LocalDate.now().plusDays(9), 401);

        List<BatchResponseDTO> batches = List.of(batchForStockDTO1,batchForStockDTO2,batchForStockDTO3);
        BatchStockDTO batchStockDTO = new BatchStockDTO(batches);

        String responseDTOString = mapper.writeValueAsString(batchStockDTO);


        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 9).param("category","FF").param("order","date_desc")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }

    @Test
    @Rollback
    @DisplayName("Retorna un 404 por parámetro inválido en categoría")
    public void getAllBatchesReturnsInvalidCategory() throws Exception {
        /* Arrange */
        loginAsAgent();

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 9).param("category","test").param("order","date_desc")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @Rollback
    @DisplayName("Retorna un 404 por parámetro inválido en order")
    public void getAllBatchesInvalidOrder() throws Exception {
        /* Arrange */
        loginAsAgent();

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 9).param("category","FF").param("order","test")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @Rollback
    @DisplayName("Retorna un 404 por parámetro inválido en dueDays")
    public void getAllBatchesInvalidDays() throws Exception {
        /* Arrange */
        loginAsAgent();

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", -1).param("category","FF").param("order","date_asc")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}

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
    @DisplayName("Obtener la lista de batches con fecha de vencimiento entre el dia actual y el día siguiente")
    public void getAllBatches() throws Exception {


        /* Arrange */
        loginAsAgent();
        loadDbScript.loadDb();

        BatchResponseDTO batchForStockDTO1 = new BatchResponseDTO(1L,1L,0,LocalDate.now() ,500);

        List<BatchResponseDTO> batches = new ArrayList<>();
        batches.add(batchForStockDTO1);
        BatchStockDTO batchStockDTO = new BatchStockDTO(batches);

        String responseDTOString = mapper.writeValueAsString(batchStockDTO);


        //Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json(responseDTOString);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        //Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/batch/list/due-date/{cantDays}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        // Act & Assert
        mockMvc.perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);

    }
}

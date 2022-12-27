package com.example.frescos.integration;

import com.example.frescos.config.LoadDbScript;
import com.example.frescos.controller.SessionController;
import com.example.frescos.repository.ApplicationUserRepository;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    @Test
    @Rollback
    @DisplayName("Obtener la lista de batches con fecha de vencimiento entre el dia actual y el siguiente")
    public void getAllBatches() throws Exception {
        loginAsAgent();
    /*
        Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson   = MockMvcResultMatchers.content().json();
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(get("/api/v1/fresh-products/batch/list/due-date/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", agentToken))
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    */
    }
}

package com.example.frescos.integration;

import com.example.frescos.config.LoadDbScript;
import com.example.frescos.controller.SessionController;
import com.example.frescos.dtos.ApplicationUserRequestDTO;
import com.example.frescos.dtos.ApplicationUserResponseDTO;
import com.example.frescos.repository.ApplicationUserRepository;
import com.example.frescos.service.SessionServiceImpl;
import com.example.frescos.utils.LoginManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class InboundOrderIntegrationTests {
    @Autowired
    private MockMvc mockMvc;
    private static ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    private static String agentToken;
    @Autowired
    private LoadDbScript loadDbScript;

    private static SessionController sessionController = new SessionController();

    private void loginAsAgent() throws Exception {
        agentToken=  LoginManager.loginAsAgent(mockMvc);
    }
    @Test
    @Rollback
    @DisplayName("Agregar una orden de entrada de mercadería")
    public void addInboundOrder() throws Exception {
        loginAsAgent();
        String content = "{\n" +
                "    \"inbound_order\": {\n" +
                "        \"order_number\": 4,\n" +
                "        \"order_date\": \"11-11-2022\",\n" +
                "        \"section\": {\n" +
                "            \"section_code\": 0,\n" +
                "            \"warehouse_code\": 2\n" +
                "        },\n" +
                "        \"batch_stock\": [\n" +
                "            {\n" +
                "                \"batch_number\": 20,\n" +
                "                \"product_id\": 1,\n" +
                "                \"current_temperature\": 15.0,\n" +
                "                \"minimum_temperature\": 20.0,\n" +
                "                \"initial_quantity\": 100,\n" +
                "                \"current_quantity\": 100,\n" +
                "                \"manufacturing_date\": \"11-10-2022\",\n" +
                "                \"manufacturing_time\": \"11-10-2022 00:00:00\",\n" +
                "                \"due_date\": \"11-10-2023\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n";

        mockMvc.perform(post("/api/v1/fresh-products/inboundorder")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .header("Authorization", agentToken))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @Rollback
    @DisplayName("Editar una orden de entrada de mercadería")
    public void updateInboundOrder() throws Exception {
        loginAsAgent();
        String content1 = "{\n" +
                "    \"inbound_order\": {\n" +
                "        \"order_number\": 4,\n" +
                "        \"order_date\": \"11-11-2022\",\n" +
                "        \"section\": {\n" +
                "            \"section_code\": 0,\n" +
                "            \"warehouse_code\": 2\n" +
                "        },\n" +
                "        \"batch_stock\": [\n" +
                "            {\n" +
                "                \"batch_number\": 20,\n" +
                "                \"product_id\": 1,\n" +
                "                \"current_temperature\": 15.0,\n" +
                "                \"minimum_temperature\": 20.0,\n" +
                "                \"initial_quantity\": 100,\n" +
                "                \"current_quantity\": 100,\n" +
                "                \"manufacturing_date\": \"11-10-2022\",\n" +
                "                \"manufacturing_time\": \"11-10-2022 00:00:00\",\n" +
                "                \"due_date\": \"11-10-2023\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n";

        mockMvc.perform(post("/api/v1/fresh-products/inboundorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content1)
                        .header("Authorization", agentToken))
                .andDo(print());

        String content2 = "{\n" +
                "    \"inbound_order\": {\n" +
                "        \"order_number\": 4,\n" +
                "        \"order_date\": \"11-11-2022\",\n" +
                "        \"section\": {\n" +
                "            \"section_code\": 0,\n" +
                "            \"warehouse_code\": 2\n" +
                "        },\n" +
                "        \"batch_stock\": [\n" +
                "            {\n" +
                "                \"batch_number\": 20,\n" +
                "                \"product_id\": 2,\n" +
                "                \"current_temperature\": 15.0,\n" +
                "                \"minimum_temperature\": 20.0,\n" +
                "                \"initial_quantity\": 100,\n" +
                "                \"current_quantity\": 100,\n" +
                "                \"manufacturing_date\": \"11-10-2022\",\n" +
                "                \"manufacturing_time\": \"11-10-2022 00:00:00\",\n" +
                "                \"due_date\": \"23-11-2023\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        mockMvc.perform(put("/api/v1/fresh-products/inboundorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content2)
                        .header("Authorization", agentToken))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @Rollback
    @DisplayName("Editar una orden de entrada de mercadería que no existe retorna 404")
    public void updateInboundOrderNotFound() throws Exception {
        loginAsAgent();

        String content2 = "{\n" +
                "    \"inbound_order\": {\n" +
                "        \"order_number\": 100,\n" +
                "        \"order_date\": \"11-11-2022\",\n" +
                "        \"section\": {\n" +
                "            \"section_code\": 0,\n" +
                "            \"warehouse_code\": 2\n" +
                "        },\n" +
                "        \"batch_stock\": [\n" +
                "            {\n" +
                "                \"batch_number\": 2,\n" +
                "                \"product_id\": 2,\n" +
                "                \"current_temperature\": 15.0,\n" +
                "                \"minimum_temperature\": 20.0,\n" +
                "                \"initial_quantity\": 100,\n" +
                "                \"current_quantity\": 100,\n" +
                "                \"manufacturing_date\": \"11-10-2022\",\n" +
                "                \"manufacturing_time\": \"11-10-2022 00:00:00\",\n" +
                "                \"due_date\": \"23-11-2023\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        mockMvc.perform(put("/api/v1/fresh-products/inboundorder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content2)
                        .header("Authorization", agentToken))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}

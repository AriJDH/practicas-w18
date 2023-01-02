package com.mercadolibre.pf_be_java_hisp_w18_g1.integration;

import com.mercadolibre.pf_be_java_hisp_w18_g1.utils.LoginManager;
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
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProductIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    private static String agentToken;

    private void loginAsAgent() throws Exception {
        agentToken=  LoginManager.loginAsAgent(mockMvc);
    }
    @Test
    @Rollback
    @DisplayName("REQ3 -  Consultar un producto en stock en el warehouse ordenados por fecha de vencimiento.")
    public void getListProductOk() throws Exception {
        //Arrange
        loginAsAgent();
        Long productId = 4L;
        String date1 = LocalDate.now().plusDays(30).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String date2 = LocalDate.now().plusDays(150).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String date3 = LocalDate.now().plusDays(50).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String date4 = LocalDate.now().plusDays(60).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        String expect = "[\n" +
                "    {\n" +
                "        \"section\": {\n" +
                "            \"section_code\": 1,\n" +
                "            \"warehouse_code\": 2\n" +
                "        },\n" +
                "        \"producto_id\": 4,\n" +
                "        \"batches\": [\n" +
                "            {\n" +
                "                \"batch_number\": 4,\n" +
                "                \"current_quantity\": 4002,\n" +
                "                \"due_date\":" + date1 + "\n" +
                "            },\n" +
                "            {\n" +
                "                \"batch_number\": 14,\n" +
                "                \"current_quantity\": 8070,\n" +
                "                \"due_date\":" + date3 + "\n" +
                "            },\n" +
                "            {\n" +
                "                \"batch_number\": 13,\n" +
                "                \"current_quantity\": 400,\n" +
                "                \"due_date\":" + date2 + "\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"section\": {\n" +
                "            \"section_code\": 1,\n" +
                "            \"warehouse_code\": 6\n" +
                "        },\n" +
                "        \"producto_id\": 4,\n" +
                "        \"batches\": [\n" +
                "            {\n" +
                "                \"batch_number\": 15,\n" +
                "                \"current_quantity\": 10,\n" +
                "                \"due_date\":" + date4 + "\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/{idProduct}/batch/list/", productId)
                .param("order", "F")
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
        //Arrange
        loginAsAgent();
        Long productId = 4L;
        String date1 = LocalDate.now().plusDays(30).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String date2 = LocalDate.now().plusDays(150).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String date3 = LocalDate.now().plusDays(50).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String date4 = LocalDate.now().plusDays(60).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        String expect = "[\n" +
                "    {\n" +
                "        \"section\": {\n" +
                "            \"section_code\": 1,\n" +
                "            \"warehouse_code\": 2\n" +
                "        },\n" +
                "        \"producto_id\": 4,\n" +
                "        \"batches\": [\n" +
                "            {\n" +
                "                \"batch_number\": 4,\n" +
                "                \"current_quantity\": 4002,\n" +
                "                \"due_date\":" + date1 + "\n" +
                "            },\n" +
                "            {\n" +
                "                \"batch_number\": 13,\n" +
                "                \"current_quantity\": 400,\n" +
                "                \"due_date\":"+ date2 + "\n" +
                "            },\n" +
                "            {\n" +
                "                \"batch_number\": 14,\n" +
                "                \"current_quantity\": 8070,\n" +
                "                \"due_date\":" + date3 + "\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    {\n" +
                "        \"section\": {\n" +
                "            \"section_code\": 1,\n" +
                "            \"warehouse_code\": 6\n" +
                "        },\n" +
                "        \"producto_id\": 4,\n" +
                "        \"batches\": [\n" +
                "            {\n" +
                "                \"batch_number\": 15,\n" +
                "                \"current_quantity\": 10,\n" +
                "                \"due_date\":" + date4 + "\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

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
                .param("order", "K")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }

    @Test
    @Rollback
    @DisplayName("REQ3 - Consultar un producto sin stock")

    public void getListProductNotFound() throws Exception {
        //Arrange
        loginAsAgent();
        Long productId = 10L;

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/{idProduct}/batch/list/", productId)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus);
    }

    @Test
    @Rollback
    @DisplayName("REQ4 - Consultar un producto en diferentes warehouse")

    public void getListProduct() throws Exception {
        //Arrange
        loginAsAgent();
        Long productId = 4L;

        String expect = "{\n" +
                "    \"producto_id\": 4,\n" +
                "    \"warehouses\": [\n" +
                "        {\n" +
                "            \"warehouse_code\": 2,\n" +
                "            \"total_quantity\": 12472\n" +
                "        },\n" +
                "        {\n" +
                "            \"warehouse_code\": 6,\n" +
                "            \"total_quantity\": 10\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        // Matchers
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(expect);
        ResultMatcher expectedContentType = MockMvcResultMatchers
                .content()
                .contentType(MediaType.APPLICATION_JSON);

        // Request
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders
                .get("/api/v1/fresh-products/{idProduct}/warehouse/list", productId)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", agentToken);

        //Act - Assert
        mockMvc
                .perform(requestPayload)
                .andDo(print())
                .andExpectAll(expectedStatus, expectedJson, expectedContentType);
    }
}

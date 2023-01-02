package com.mercadolibre.pf_be_java_hisp_w18_g1.integration;

import com.mercadolibre.pf_be_java_hisp_w18_g1.config.LoadDbScript;
import com.mercadolibre.pf_be_java_hisp_w18_g1.utils.LoginManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PurchaseOrderIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    private static  String buyerToken;

    private static  String agentToken;

    @Autowired
    private LoadDbScript loadDbScript;

    private void loginAsAgent() throws Exception {
        agentToken=  LoginManager.loginAsAgent(mockMvc);
    }

    private void loginAsBuyer() throws Exception {
        buyerToken = LoginManager.loginAsBuyer(mockMvc);
    }
/*
    @Test
    @Rollback
    @DisplayName("Agregar una orden de compra")
    public void addPurchaseOrder() throws Exception {

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
                "                \"batch_number\": 16,\n" +
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
                .andDo(print())
                .andExpect(status().isCreated());

        loginAsBuyer();

        String content = "{\n" +
                "    \"purchase_order\": {\n" +
                "        \"date\": \"28-12-2022\",\n" +
                "        \"buyer_id\": 6, \n" +
                "        \"order_status\": {\n" +
                "           \"status_code\": \"carrito\" \n" +
                "        }, \n" +
                "        \"products\": [\n" +
                "           {\n" +
                "                \"product_id\": 1,\n" +
                "                \"quantity\": 1\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n";

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                        .header("Authorization", buyerToken))
                .andDo(print())
                .andExpect(status().isCreated());
    }

 */
    @Test
    @Rollback
    @DisplayName("Purchase Order not Found")
    public void getPurchaseOrderNotFound() throws Exception {

        loginAsBuyer();
        mockMvc.perform(get("/api/v1/fresh-products/orders/1000")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", buyerToken))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}

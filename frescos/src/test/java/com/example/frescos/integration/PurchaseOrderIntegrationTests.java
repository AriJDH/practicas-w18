package com.example.frescos.integration;

import com.example.frescos.utils.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PurchaseOrderIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    private static  String buyerToken;

    private void loginAsBuyer() throws Exception {
        buyerToken = LoginManager.loginAsBuyer(mockMvc);
    }

}

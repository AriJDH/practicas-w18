package com.mercadolibre.pf_be_java_hisp_w18_g1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ApplicationUserResponseDTO;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc
public class LoginManager {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static String loginAsAgent(MockMvc mockMvc) throws Exception {
        String data = "{\n" +
                "    \"user_name\": \"MarcosInfantino\",\n" +
                "    \"password\": \"admin\"\n" +
                "}";
        return login(data, mockMvc);
    }

    public static String loginAsBuyer(MockMvc mockMvc) throws Exception {
        String data = "{\n" +
                "    \"user_name\": \"MiguelAvalle\",\n" +
                "    \"password\": \"admin\"\n" +
                "}";
        return login(data, mockMvc);
    }

    public static String login(String data, MockMvc mockMvc) throws Exception {
        MvcResult result=mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(data)).andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println(jsonResponse);
        ApplicationUserResponseDTO applicationUserResponseDTO = objectMapper.readValue(
                jsonResponse, ApplicationUserResponseDTO.class);
        return applicationUserResponseDTO.getToken();
    }

}

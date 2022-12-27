package com.example.frescos.utils;

import com.example.frescos.controller.SessionController;
import com.example.frescos.dtos.ApplicationUserRequestDTO;
import com.example.frescos.dtos.ApplicationUserResponseDTO;
import com.example.frescos.repository.ApplicationUserRepository;
import com.example.frescos.service.SessionService;
import com.example.frescos.service.SessionServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
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
        MvcResult result=mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(data)).andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println(jsonResponse);
        ApplicationUserResponseDTO applicationUserResponseDTO = objectMapper.readValue(jsonResponse, ApplicationUserResponseDTO.class);
        return applicationUserResponseDTO.getToken();
    }

}

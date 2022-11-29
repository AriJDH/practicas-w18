package com.dh.be_java_hisp_w18_g10.integration;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.ProductDTOreq;;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class integration {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integracion 002 - ")
    void followCountOk() throws Exception{

        //Arrange
        int userId = 2;

        //MockMVC
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers_count").value(2))
                .andExpect(jsonPath("$.user_name").value("usuario_2"));

    }

    @Test
    @DisplayName("Integracion 005 - ")
    void addPostTestOk() throws Exception{

        String date = LocalDate.now().getDayOfMonth() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getYear();
                ProductDTOreq productDTOreq = new ProductDTOreq(3, "Playstation", "5", "Sony", "blanca", "nueva");
        PostDTOreq postDTOreq = new PostDTOreq(2, date , productDTOreq, 1, 23.000);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadPostDTO = writer.writeValueAsString(postDTOreq);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON).content(payloadPostDTO))
                .andDo(print())
                .andExpect(status().isOk());

    }


}

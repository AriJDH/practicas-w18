package com.example.socialmeli2.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class PublicationControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Nested
    @DisplayName("IT - POST createPublication")
    class createPublication {

        @Test
        @DisplayName("Success")
        void test1() throws Exception {

            //Arrange
            String requestbody = "{\n" +
                    "    \"user_id\": 1,\n" +
                    "    \"date\": \"17-11-2022\",\n" +
                    "    \"product\": {\n" +
                    "        \"product_id\": 5,\n" +
                    "        \"product_name\": \"s\",\n" +
                    "        \"type\": \"Gamer\",\n" +
                    "        \"brand\": \"Racer\",\n" +
                    "        \"color\": \"Red y Black\",\n" +
                    "        \"notes\": \"\"\n" +
                    "    },\n" +
                    "    \"category\": 100,\n" +
                    "    \"price\": 700.50\n" +
                    "}";

            //Matchers
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
            //ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseBody);
            //ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

            //Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestbody);

            //Act & Assert
            mockMvc
                    .perform(request)
                    .andDo(print())
                    .andExpectAll(expectedStatus);

        }

        @Test
        @DisplayName("Not Success - Throws Fields Validations")
        void test2() throws Exception {

            //Arrange

            /*Integer userId = 1;
            //LocalDate date = LocalDate.parse("");
            ProductRequest productRequest = ProductFactory.getProductRequestWithInvalidFields();
            Integer category = 1;
            Double price = 1.5D;

            PublicationRequest publicationRequest = new PublicationRequest(userId, date, productRequest, category, price);
            */

            String requestbody = "{\n" +
                    "    \"user_id\": 0,\n" +
                    "    \"date\": \"\",\n" +
                    "    \"product\": {\n" +
                    "        \"product_id\": 0,\n" +
                    "        \"product_name\": \"\",\n" +
                    "        \"type\": \"$$Gamer$$\",\n" +
                    "        \"brand\": \"anyBrand.co\",\n" +
                    "        \"color\": \"numeroDeCaracteresQueSuperaLaValidacion\",\n" +
                    "        \"notes\": \" $$ \"\n" +
                    "    },\n" +
                    "    \"category\": null,\n" +
                    "    \"price\": 70000000000000000.50\n" +
                    "}";

            String responseBody = "{\n" +
                    "    \"errorValidationResponseList\": [\n" +
                    "        {\n" +
                    "            \"field\": \"productRequest.color\",\n" +
                    "            \"rejectedValue\": \"numeroDeCaracteresQueSuperaLaValidacion\",\n" +
                    "            \"message\": \"La longitud no puede superar los 15 caracteres\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"userId\",\n" +
                    "            \"rejectedValue\": 0,\n" +
                    "            \"message\": \"El id debe ser mayor a cero.\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"productRequest.name\",\n" +
                    "            \"rejectedValue\": \"\",\n" +
                    "            \"message\": \"El campo no puede estar vacío.\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"productRequest.type\",\n" +
                    "            \"rejectedValue\": \"$$Gamer$$\",\n" +
                    "            \"message\": \"El campo no puede poseer caracteres especiales\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"productRequest.notes\",\n" +
                    "            \"rejectedValue\": \" $$ \",\n" +
                    "            \"message\": \"El campo no puede poseer caracteres especiales.\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"date\",\n" +
                    "            \"rejectedValue\": null,\n" +
                    "            \"message\": \"El campo no puede estar vacío.\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"category\",\n" +
                    "            \"rejectedValue\": null,\n" +
                    "            \"message\": \"El campo no puede estar vacío.\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"price\",\n" +
                    "            \"rejectedValue\": 7.0E16,\n" +
                    "            \"message\": \"El precio máximo por producto es de 10.000.000\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"productRequest.id\",\n" +
                    "            \"rejectedValue\": 0,\n" +
                    "            \"message\": \"El id debe ser mayor a cero.\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"date\",\n" +
                    "            \"rejectedValue\": null,\n" +
                    "            \"message\": \"El campo no puede estar vacío.\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"field\": \"category\",\n" +
                    "            \"rejectedValue\": null,\n" +
                    "            \"message\": \"El campo no puede estar vacío.\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";


            //Matchers
            ResultMatcher expectedStatus = MockMvcResultMatchers.status().isBadRequest();
            ResultMatcher expectedJson = MockMvcResultMatchers.content().json(responseBody);
            ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

            //Request
            MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                    .post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestbody);

            //Act & Assert
            mockMvc
                    .perform(request)
                    .andDo(print())
                    .andExpectAll(expectedStatus, expectedContentType, expectedJson);

        }
    }

}

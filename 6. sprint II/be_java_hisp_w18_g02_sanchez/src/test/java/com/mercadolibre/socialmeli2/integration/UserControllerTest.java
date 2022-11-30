package com.mercadolibre.socialmeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.ResponseDto;
import com.mercadolibre.socialmeli2.repository.UserRepository;
import com.mercadolibre.socialmeli2.utils.Constants;
import com.mercadolibre.socialmeli2.utils.PostDtoReqFactory;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                      .registerModule(new JavaTimeModule())
                      .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                      .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void beforeEach(){
        this.userRepository.setUsers(UserFactory.loadUsers());
    }

    @Test
    @DisplayName("T-INT-0001 Verificar agregar publicación (US-0005). Caso de éxito.")
    public void testAddPostSuccesfully() throws Exception {
        //Arrenge
        PostDtoReq postDtoReq = PostDtoReqFactory.getPostDtoReq(3);
        ResponseDto expectedResponseDto = new ResponseDto(Constants.SUCCESS_MSG_ADD_POST, 200);

        String payload = writer.writeValueAsString(postDtoReq);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act and Assert
        mockMvc.perform(request).andDo(print()).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.messages").value(expectedResponseDto.getMessages()),
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
        );
    }

    @Test
    @DisplayName("T-INT-0001 Verificar agregar publicación (US-0005). Caso de error (usuario no existe).")
    public void testAddPostFailureUserNotExists() throws Exception {
        //Arrenge
        PostDtoReq postDtoReq = PostDtoReqFactory.getPostDtoReq(9999);
        ResponseDto eDto = new ResponseDto(Constants.ERROR_MSG_USER_NOT_FOUND + postDtoReq.getUserId(), 404);
        ResponseEntity<ResponseDto> expectedResponse = new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));

        String payload = writer.writeValueAsString(postDtoReq);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        //Act and Assert
        mockMvc.perform(request).andDo(print()).andExpectAll(
                MockMvcResultMatchers.status().isNotFound(),
                MockMvcResultMatchers.jsonPath("$.messages").value(expectedResponse.getBody().getMessages()),
                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)
        );
    }

    @Test
    @DisplayName("T-INT-0002 Verificar validaciones DTOs. Caso de error (atributos nulos y vacíos.")
    public void testAddPostFailureNullAndBlankValidations() throws Exception {
        //Arrenge and Act
        PostDtoReq postDtoReq = PostDtoReqFactory.getInvalidPostDtoReqNullsAndBlanks();
        ResponseDto eDto = new ResponseDto(Constants.ERROR_MSG_USER_NOT_FOUND + postDtoReq.getUserId(), 404);
        ResponseEntity<ResponseDto> expectedResponse = new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));

        String payload = writer.writeValueAsString(postDtoReq);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        JSONObject responseJson = new JSONObject(response.getContentAsString(Charset.defaultCharset()));
        String[] msgsArray = new ObjectMapper().readValue(responseJson.getString("messages"), String[].class);
        List<String> msgsList = new ArrayList<>(Arrays.asList(msgsArray));

        //Assert
        assertTrue(msgsList.contains(Constants.COLOR_REQUIRED));
        assertTrue(msgsList.contains(Constants.BRAND_REQUIRED));
        assertTrue(msgsList.contains(Constants.TYPE_REQUIRED));
        assertTrue(msgsList.contains(Constants.PRODUCT_NAME_REQUIRED));
        assertTrue(msgsList.contains(Constants.PRODUCT_ID_REQUIRED));
        assertTrue(msgsList.contains(Constants.PRICE_REQUIRED));
        assertTrue(msgsList.contains(Constants.CATEGORY_REQUIRED));
        assertTrue(msgsList.contains(Constants.DATE_REQUIRED));
        assertTrue(msgsList.contains(Constants.USER_ID_REQUIRED));

        //System.out.println("\nMENSAJES DE ERROR OBTENIDOS "+msgsList.size()+":\n"+msgsList);
    }

    @Test
    @DisplayName("T-INT-0002 Verificar validaciones DTOs. Caso de error (atributos con tamaños y valores no permitidos.")
    public void testAddPostFailureSizeAndValueValidations() throws Exception {
        //Arrenge and Act
        PostDtoReq postDtoReq = PostDtoReqFactory.getInvalidPostDtoReqSizeAndValue();
        ResponseDto eDto = new ResponseDto(Constants.ERROR_MSG_USER_NOT_FOUND + postDtoReq.getUserId(), 404);
        ResponseEntity<ResponseDto> expectedResponse = new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));

        String payload = writer.writeValueAsString(postDtoReq);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        JSONObject responseJson = new JSONObject(response.getContentAsString(Charset.defaultCharset()));
        String[] msgsArray = new ObjectMapper().readValue(responseJson.getString("messages"), String[].class);
        List<String> msgsList = new ArrayList<>(Arrays.asList(msgsArray));

        //Assert
        assertTrue(msgsList.contains(Constants.PRODUCT_ID_POSITIVE));
        assertTrue(msgsList.contains(Constants.PRODUCT_NAME_MAX_LENGTH_40));
        assertTrue(msgsList.contains(Constants.TYPE_MAX_LENGTH_15));
        assertTrue(msgsList.contains(Constants.BRAND_MAX_LENGTH_15));
        assertTrue(msgsList.contains(Constants.COLOR_MAX_LENGTH_15));
        assertTrue(msgsList.contains(Constants.MAX_LENGTH_80));
        assertTrue(msgsList.contains(Constants.USER_ID_POSITIVE));
        assertTrue(msgsList.contains(Constants.MAX_PRICE));

        //System.out.println("\nMENSAJES DE ERROR OBTENIDOS "+msgsList.size()+":\n"+msgsList);
    }

    @Test
    @DisplayName("T-INT-0002 Verificar validaciones DTOs. Caso de error (atributos caract. esp. y otros).")
    public void testAddPostFailureRemainingValidations() throws Exception {
        //Arrenge and Act
        PostDtoReq postDtoReq = PostDtoReqFactory.getInvalidPostDtoReqOther();
        ResponseDto eDto = new ResponseDto(Constants.ERROR_MSG_USER_NOT_FOUND + postDtoReq.getUserId(), 404);
        ResponseEntity<ResponseDto> expectedResponse = new ResponseEntity<>(eDto, HttpStatus.valueOf(eDto.getStatus()));

        String payload = writer.writeValueAsString(postDtoReq);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload);

        MockHttpServletResponse response = mockMvc.perform(request).andReturn().getResponse();
        JSONObject responseJson = new JSONObject(response.getContentAsString(Charset.defaultCharset()));
        String[] msgsArray = new ObjectMapper().readValue(responseJson.getString("messages"), String[].class);
        List<String> msgsList = new ArrayList<>(Arrays.asList(msgsArray));

        //Assert
        assertTrue(msgsList.contains(Constants.MIN_PRICE));
        assertTrue(msgsList.contains(Constants.NOTES_SPECIAL_CHARACTERS_NOT_ALLOWED));
        assertTrue(msgsList.contains(Constants.COLOR_SPECIAL_CHARACTERS_NOT_ALLOWED));
        assertTrue(msgsList.contains(Constants.BRAND_SPECIAL_CHARACTERS_NOT_ALLOWED));
        assertTrue(msgsList.contains(Constants.TYPE_SPECIAL_CHARACTERS_NOT_ALLOWED));
        assertTrue(msgsList.contains(Constants.PRODUCT_NAME_SPECIAL_CHARACTERS_NOT_ALLOWED));

        //System.out.println("\nMENSAJES DE ERROR OBTENIDOS "+msgsList.size()+":\n"+msgsList);
    }


}

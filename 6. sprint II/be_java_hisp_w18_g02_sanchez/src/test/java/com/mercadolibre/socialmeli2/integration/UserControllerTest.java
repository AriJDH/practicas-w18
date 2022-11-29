package com.mercadolibre.socialmeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.ResponseDto;
import com.mercadolibre.socialmeli2.repository.UserRepository;
import com.mercadolibre.socialmeli2.utils.UserFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

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
    public void testAddPostSuccesfully() throws Exception {
        //Arrenge
        ProductDto productDtoReq = new ProductDto(1, "Remera", "Indumentaria","Adidas",
                                            "Negra", "Stock limitado");
        PostDtoReq postDtoReq = new PostDtoReq(3, LocalDate.now(), productDtoReq, 1, 4000.00);
        ResponseDto expectedResponseDto = new ResponseDto("Post creado correctamente", 200);

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
}

package com.mercadolibre.socialmeli2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.socialmeli2.dto.ProductDto;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.PostDtoRes;
import com.mercadolibre.socialmeli2.dto.response.RecentPostsDtoRes;
import com.mercadolibre.socialmeli2.entity.Post;
import com.mercadolibre.socialmeli2.entity.Product;
import com.mercadolibre.socialmeli2.repository.IUserRepository;
import com.mercadolibre.socialmeli2.utils.Constants;
import com.mercadolibre.socialmeli2.utils.UtilsFactory;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mercadolibre.socialmeli2.utils.Constants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    private JSONParser jsonParser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
    private ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    private void addPostTest(PostDtoReq postReq, List<String> expected, boolean isValid) throws Exception {
        // Arrange
        String payload = mapper.writeValueAsString(postReq);
        JSONArray messages = (JSONArray) jsonParser.parse(mapper.writeValueAsString(expected));

        /* Matchers */
        ResultMatcher expectedStatus = isValid ? MockMvcResultMatchers.status().isCreated() : MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher expectedMessage = MockMvcResultMatchers.jsonPath("$.messages").value(Matchers.containsInAnyOrder(messages.toArray()));
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payload);

        // Act
        // Assert
        mockMvc.perform(requestPayload).andDo(print()).andExpectAll(expectedStatus, expectedMessage, expectedContentType);
    }

    @Test
    @DisplayName("Add Post: Post Válido")
    void test01() throws Exception {
        // Arrange
        PostDtoReq postDtoReq = new PostDtoReq(1, LocalDate.now(), new ProductDto(1, "Nombre", "Tipo", "Marca", "Color", null), 1, 1.0);
        this.addPostTest(postDtoReq, Arrays.asList("Post creado correctamente"), true);
    }

    @Test
    @DisplayName("Add Post: Post no Válido (campos requeridos)")
    void test02() throws Exception {
        // Arrange
        PostDtoReq postDtoReq = new PostDtoReq(null, null, new ProductDto(), null, null);
        this.addPostTest(postDtoReq, UtilsFactory.requiredFieldsMessages(), false);
    }

    @Test
    @DisplayName("Add Post: Post no Válido (campos superan los máximos permitidos)")
    void test03() throws Exception {
        // Arrange
        PostDtoReq postDtoReq = new PostDtoReq(1, LocalDate.now(), new ProductDto(1, "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfg", "qwertyuiopasdfgh", "qwertyuiopasdfgh", "qwertyuiopasdfgh", "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfgqwertyuiopasdfghjklzxcvbnmqwertyuiopasdf"), 1, 10000001.0);
        this.addPostTest(postDtoReq, UtilsFactory.maxValidMessages(), false);
    }

    @Test
    @DisplayName("Add Post: Post no Válido (campos inferiores a los mínimos permitidos)")
    void test04() throws Exception {
        // Arrange
        PostDtoReq postDtoReq = new PostDtoReq(-1, LocalDate.now(), new ProductDto(0, "Nombre", "Tipo", "Marca", "Color", null), 1, 0.0);
        this.addPostTest(postDtoReq, UtilsFactory.minValidMessages(), false);
    }

    @Test
    @DisplayName("Add Post: Post no Válido (campos con caracteres especiales)")
    void test05() throws Exception {
        // Arrange
        PostDtoReq postDtoReq = new PostDtoReq(1, LocalDate.now(), new ProductDto(1, "Nombre$", "Tipo$", "Marca$", "Color$", "Nota$"), 1, 1.0);
        this.addPostTest(postDtoReq, UtilsFactory.regexPatternMessages(), false);
    }

    @Test
    @DisplayName("Add Post: Usuario no existe")
    void test06() throws Exception {
        // Arrange
        PostDtoReq postDtoReq = new PostDtoReq(99, LocalDate.now(), new ProductDto(1, "Nombre", "Tipo", "Marca", "Color", null), 1, 1.0);
        this.addPostTest(postDtoReq, Arrays.asList("No se pudo encontrar al usuario 99"), false);
    }

    @Test
    @DisplayName("Get Recent Posts: Válido")
    void getRecentPostTest() throws Exception {
        // Arrange
        Integer userId = 1;
        String order = "date_asc";
        ProductDto pr1 = new ProductDto(1, "Mouse inalámbrico", "Acessorio",
                "Logitech", "Negro", "Usa pila AA.");

        ProductDto pr2 = new ProductDto(2, "Bicicleta de montaña R26", "Rodado",
                "Winner", "Roja", "18 velocidades.");

        PostDtoRes post1 = new PostDtoRes(3,1, LocalDate.now(), pr1,  1, 15.5);
        PostDtoRes post2 = new PostDtoRes(4, 2, LocalDate.now().minusDays(2),pr2,  2, 15999.99);

        RecentPostsDtoRes expected = new RecentPostsDtoRes(userId, Arrays.asList(post1,post2));
        String expectedJSON = mapper.writeValueAsString(expected);

        /* Matchers */
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(expectedJSON);
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        /* Request */
        MockHttpServletRequestBuilder requestPayload = MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId).contentType(MediaType.APPLICATION_JSON).param("order", order);

        // Act
        // Assert
        mockMvc.perform(requestPayload).andDo(print()).andExpectAll(expectedStatus, expectedContent, expectedContentType);
    }

}

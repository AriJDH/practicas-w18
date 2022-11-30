package com.meli.be_java_hisp_w18_g01.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g01.dtos.*;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import com.meli.be_java_hisp_w18_g01.services.PostService;
import com.meli.be_java_hisp_w18_g01.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository.removeAll();
    }

    @Test
    public void addPost() throws Exception {
        // Arrange
        ResponseDTO responseDTO = new ResponseDTO(200, "operación exitosa");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(1L);
        productDTO.setProduct_name("Silla Gamer");
        productDTO.setType("Gamer");
        productDTO.setBrand("Racer");
        productDTO.setColor("RedandBlack");
        productDTO.setNotes("Special Edition");

        PostDTO postDTO = new PostDTO();

        postDTO.setUser_id(1L);
        postDTO.setDate("11-11-2022");
        postDTO.setProduct(productDTO);
        postDTO.setCategory(100);
        postDTO.setPrice(1500.50);

        User lucas = new User(1L, "lucas");
        userRepository.add(lucas);

        //Mapper
        String content = this.objectMapper.writeValueAsString(postDTO);
        String stringResponseDTO = this.objectMapper.writeValueAsString(responseDTO);

        // ResultMatcher
        ResultMatcher resultMatcher = MockMvcResultMatchers.content().json(stringResponseDTO);

        //Act Assert
        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(resultMatcher);
    }

    @Test
    public void exceptionAddPost() throws Exception {

        //Arrange
        ErrorDTO errorDTO = new ErrorDTO(400, "El nombre del producto no puede contener caracteres especiales.");

        List<ErrorDTO> errorDTOList = Arrays.asList(errorDTO);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(1L);
        productDTO.setProduct_name("%s");
        productDTO.setType("Gamer");
        productDTO.setBrand("Racer");
        productDTO.setColor("RedAndBlack");
        productDTO.setNotes("Special Edition");

        PostDTO postDTO = new PostDTO();

        postDTO.setUser_id(1L);
        postDTO.setDate("11-11-2022");
        postDTO.setProduct(productDTO);
        postDTO.setCategory(100);
        postDTO.setPrice(1500.50);

        User lucas = new User(1L, "lucas");
        userRepository.add(lucas);

        //Mapper
        String content = this.objectMapper.writeValueAsString(postDTO);
        String stringResponseDTO = this.objectMapper.writeValueAsString(errorDTOList);

        //ResultMatcher
        ResultMatcher resultMatcher = MockMvcResultMatchers.content().json(stringResponseDTO);

        //Act and Assert
        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(resultMatcher);
    }

    @Test
    public void followedList() throws Exception {

        //Arrange
        ResponseDTO responseDTO = new ResponseDTO(200, "operación exitosa");

        ProductDTO productDTO = new ProductDTO(
                1L,
                "Zapatillas",
                "zapatilla",
                "Adadis",
                "Blancas",
                "Las mejores"
        );

        PostDTO postDTO = new PostDTO(
                1L,
                "30-11-2022",
                productDTO,
                100,
                20000.0
        );


        User lucas = new User(1L, "lucas");
        userRepository.add(lucas);

        User miguel = new User(2L, "miguel");
        userRepository.add(miguel);

        postService.addPost(postDTO);

        List<PostDTO> postsDTO = new ArrayList<>();
        postsDTO.add(postDTO);

        SellerDTO sellerDTO = new SellerDTO(
                1L,
                postsDTO
        );

        List<SellerDTO> sellersDTO = new ArrayList<>();
        sellersDTO.add(sellerDTO);
        userService.handleFollow(2L, 1L);

        //Mapper
        String stringResponseDTO = this.objectMapper.writeValueAsString(responseDTO);
        String stringSellerDTO = this.objectMapper.writeValueAsString(sellersDTO);
        String content = this.objectMapper.writeValueAsString(postDTO);

        // ResultMatcher
        ResultMatcher resultMatcher = MockMvcResultMatchers.content().json(stringResponseDTO);
        ResultMatcher resultMatcherSeller = MockMvcResultMatchers.content().json(stringSellerDTO);

        //Act and Assert
        this.mockMvc.perform(get("/products/followed/2/list")
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(resultMatcherSeller)
                .andReturn();
    }
}

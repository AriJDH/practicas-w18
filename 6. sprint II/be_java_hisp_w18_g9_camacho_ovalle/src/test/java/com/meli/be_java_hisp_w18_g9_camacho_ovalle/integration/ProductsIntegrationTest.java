package com.meli.be_java_hisp_w18_g9_camacho_ovalle.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Post;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Product;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.User;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.IPostRepository;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.IUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductsIntegrationTest {

    // ? ================= Attributes ================= ?

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPostRepository postRepository;

    @MockBean
    private IUserRepository userRepository;

    private static ObjectWriter writer;

    // ? ================= Before ================= ?

    @BeforeAll
    static void setUp() {
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();
    }

    // ? ================= Tests ================= ?

    @Test
    @DisplayName("Get all posts")
    void getAllPosts() throws Exception {

        Product product1 = new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!");
        Product product2 = new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!");

        when(postRepository.findAll()).thenReturn(List.of(
                new Post(1, 1, LocalDate.now(), product1, 1, 10.0, false, 0.0),
                new Post(2, 1, LocalDate.now(), product2, 1, 10.0, false, 0.0)
        ));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/post"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].post_id").value(1))
                .andExpect(jsonPath("$[0].user_id").value(1))
                .andExpect(jsonPath("$[0].product.product_name").value("Notebook Mac"))
                .andExpect(jsonPath("$[1].post_id").value(2))
                .andExpect(jsonPath("$[1].user_id").value(1))
                .andExpect(jsonPath("$[1].product.product_name").value("Notebook Dell"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Get all posts by followed users - Without order filter")
    void getAllPostsByFollowedUsersWithoutOrderFilter() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest = new User(2, "Seller test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowed(new ArrayList<>(List.of(sellerTest)));
        sellerTest.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));

        Product product1 = new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!");
        Product product2 = new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!");

        when(postRepository.findAllById(2)).thenReturn(List.of(
                new Post(1, 2, LocalDate.now(), product1, 1, 10.0, false, 0.0),
                new Post(2, 2, LocalDate.now().minusDays(5), product2, 2, 20.0, false, 0.0)
        ));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts", hasSize(2)))
                .andExpect(jsonPath("$.posts[0].date").value(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .andExpect(jsonPath("$.posts[0].product.product_name").value("Notebook Mac"))
                .andExpect(jsonPath("$.posts[1].date").value(LocalDate.now().minusDays(5).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .andExpect(jsonPath("$.posts[1].product.product_name").value("Notebook Dell"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Get all posts by followed users - Order date asc filter")
    void getAllPostsByFollowedUsersOrderDateAscFilter() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest = new User(2, "Seller test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowed(new ArrayList<>(List.of(sellerTest)));
        sellerTest.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));

        Product product1 = new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!");
        Product product2 = new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!");

        when(postRepository.findAllById(2)).thenReturn(List.of(
                new Post(1, 2, LocalDate.now(), product1, 1, 10.0, false, 0.0),
                new Post(2, 2, LocalDate.now().minusDays(5), product2, 2, 20.0, false, 0.0)
        ));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", 1)
                        .param("order", "date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts", hasSize(2)))
                .andExpect(jsonPath("$.posts[0].date").value(LocalDate.now().minusDays(5).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .andExpect(jsonPath("$.posts[0].product.product_name").value("Notebook Dell"))
                .andExpect(jsonPath("$.posts[1].date").value(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .andExpect(jsonPath("$.posts[1].product.product_name").value("Notebook Mac"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Get all posts by followed users - Order date desc filter")
    void getAllPostsByFollowedUsersOrderDateDescFilter() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User sellerTest = new User(2, "Seller test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        userTest.setFollowed(new ArrayList<>(List.of(sellerTest)));
        sellerTest.setFollowers(new ArrayList<>(List.of(userTest)));

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));

        Product product1 = new Product(1, "Notebook Mac", "Notebook", "Apple", "Gray", "Excelent!");
        Product product2 = new Product(2, "Notebook Dell", "Notebook", "Dell", "Black", "Excelent!");

        when(postRepository.findAllById(2)).thenReturn(List.of(
                new Post(1, 2, LocalDate.now(), product1, 1, 10.0, false, 0.0),
                new Post(2, 2, LocalDate.now().minusDays(5), product2, 2, 20.0, false, 0.0)
        ));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", 1)
                        .param("order", "date_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts", hasSize(2)))
                .andExpect(jsonPath("$.posts[0].date").value(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .andExpect(jsonPath("$.posts[0].product.product_name").value("Notebook Mac"))
                .andExpect(jsonPath("$.posts[1].date").value(LocalDate.now().minusDays(5).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))))
                .andExpect(jsonPath("$.posts[1].product.product_name").value("Notebook Dell"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Get all posts by followed users - Invalid order filter")
    void getAllPostsByFollowedUsersInvalidOrderFilter() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", 1)
                        .param("order", "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The order invalid is not valid, please use date_asc or date_desc"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Get all posts by followed users - User not found")
    void getAllPostsByFollowedUsersUserNotFound() throws Exception {

        when(userRepository.findById(1)).thenReturn(Optional.empty());

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with id 1 not found"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Get all posts by followed users - User not followed")
    void getAllPostsByFollowedUsersUserNotFollowed() throws Exception {

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts", hasSize(0)))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Get all posts by followed users - Invalid user id")
    void getAllPostsByFollowedUsersInvalidUserId() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/products/followed/{userId}/list", "invalid"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post")
    void createNewPost() throws Exception {

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoRequest = new PostDtoRequest(1, 1, LocalDate.now(), product, 1, 10.0);

        List<Product> products = new ArrayList<>();
        products.add(product);

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), products);

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - User not found")
    void createNewPostUserNotFound() throws Exception {

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoRequest = new PostDtoRequest(1, 1, LocalDate.now(), product, 1, 10.0);

        when(userRepository.findById(1)).thenReturn(Optional.empty());

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with id 1 not found"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - Invalid fields (Price less than 0)")
    void createNewPostInvalidFieldsPriceLessThanZero() throws Exception {

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoRequest = new PostDtoRequest(1, 1, LocalDate.now(), product, 1, -10.0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.price").value("The price field cannot be negative"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - Invalid fields (Price more than 10_000_000)")
    void createNewPostInvalidFieldsPriceMoreThanTenMillion() throws Exception {

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoRequest = new PostDtoRequest(1, 1, LocalDate.now(), product, 1, 10_000_001.0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.price").value("The price field cannot be greater than 10.000.000"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - Invalid fields (Category empty)")
    void createNewPostInvalidFieldsCategoryEmpty() throws Exception {

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoRequest = new PostDtoRequest(1, 1, LocalDate.now(), product, null, 10.0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.category").value("The category field cannot be empty"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - Invalid fields (Product empty)")
    void createNewPostInvalidFieldsProductEmpty() throws Exception {

        PostDtoRequest postDtoRequest = new PostDtoRequest(1, 1, LocalDate.now(), null, 1, 10.0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.product").value("The product field cannot be empty"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - Invalid fields (Date empty)")
    void createNewPostInvalidFieldsDateEmpty() throws Exception {

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoRequest = new PostDtoRequest(1, 1, null, product, 1, 10.0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.date").value("The date field cannot be empty"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - Invalid fields (UserID empty)")
    void createNewPostInvalidFieldsUserIdEmpty() throws Exception {

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoRequest = new PostDtoRequest(1, null, LocalDate.now(), product, 1, 10.0);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.userId").value("The user_id field cannot be null"))
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - Invalid data (Http Message Not Readable)")
    void createNewPostInvalidDataHttpMessageNotReadable() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString("")))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

    }

    // * ================ *

    @Test
    @DisplayName("Create a new post - Product not associated with user")
    void createNewPostProductNotAssociatedWithUser() throws Exception {

        Product product = new Product(1, "Macbook!!", "Notebook", "Apple", "Gray", "Excelent!");
        PostDtoRequest postDtoRequest = new PostDtoRequest(1, 2, LocalDate.now(), product, 1, 10.0);

        List<Product> products = new ArrayList<>();
        products.add(product);

        User userTest = new User(1, "User test 1", new ArrayList<>(), new ArrayList<>(), products);
        User userTest2 = new User(2, "User test 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(userTest));
        when(userRepository.findById(2)).thenReturn(Optional.of(userTest2));

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postDtoRequest)))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.message").value("Product not associated with user"))
                .andReturn();

    }

    // * ================ *

}

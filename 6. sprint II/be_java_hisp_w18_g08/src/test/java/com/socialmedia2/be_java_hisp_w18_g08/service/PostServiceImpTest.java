package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.PostDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ProductDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Product;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.exception.NotFoundUserException;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PostServiceImpTest {

    //Revisar si realmente hacen falta los dos repos

    @Mock
    UserRepositoryImp userRepo;
    @Mock
    PostRepositoryImp postRepo;
    @Mock
    UserServiceImp userService;
    @InjectMocks
    PostServiceImp postService;
    User u1;
    PostDto postDto1;
    PostDto postDto2;

    @BeforeEach
    private void setup() {
        //T-0005
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("20-11-2022", formatter);

        List<Post> postList = new ArrayList<>();
        List<User> followers = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();
        Product product1;
        Product product2;
        Seller s1;

        s1 = new Seller(1, "Seller1", followed, postList, followers);

        u1 = new User(2,"User1",followed);

        product1 = new Product(1,"Silla","Oficina","Reclinable","Negro","Silla para oficina");
        product2 = new Product(2,"Vaso","Utensilio","Termico","Negro","Vaso termico");

        Post post1 = new Post(1,1,product1,1,4000.0,date);
        Post post2 = new Post(2,1,product2,2,1000.0,date.plusDays(7));

        postList.add(post1);
        postList.add(post2);

        followers.add(u1);

        followed.add(s1);

        //T-0006
        ProductDtoRes productDto1 = new ProductDtoRes(1,"Silla","Oficina","Reclinable","Negro","Silla para oficina");
        ProductDtoRes productDto2 = new ProductDtoRes(2,"Vaso","Utensilio","Termico","Negro","Vaso termico");

        postDto1 = new PostDto(1,1,productDto1,1,4000.0,date);
        postDto2 = new PostDto(2,1,productDto2,2,1000.0,date.plusDays(7));
    }

    @Test
    void create() {
    }

    @Test
    @DisplayName("T-0005-OK-Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
    void getPostSellerListByUserIdOKTest() {
        //Arrange
        Integer id = 2;
        String order = "date_asc";

        //Mock
        when(userService.getFollowedByUserId(id)).thenReturn(u1.getFollowed());

        //Act
        PostDtoRes result = postService.getPostSellerListByUserId(id, order);

        //Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("T-0005-NoOK-Verificar que el tipo de ordenamiento por fecha exista (US-0009)")
    void getPostSellerListByUserIdNoOKTest() {
        //Arrange
        Integer id = 2;
        String order = "sin_orden";

        //Mock
        when(userService.getFollowedByUserId(id)).thenReturn(u1.getFollowed());

        //Assert - Act
        assertThrows(NotFoundUserException.class, () -> postService.getPostSellerListByUserId(id, order));
    }

    @Test
    @DisplayName("T-0006-OK-Verificar el correcto ordenamiento ascendente por fecha. (US-0009)")
    void getPostSellerListByUserIdAscendentOKTest() {
        //Arrange
        Integer id = 2;
        String order = "date_asc";
        List<PostDto> expectedPost = List.of(postDto1, postDto2);

        //Mock
        when(userService.getFollowedByUserId(id)).thenReturn(u1.getFollowed());

        //Act
        PostDtoRes result = postService.getPostSellerListByUserId(id, order);

        //Assert
        assertEquals(expectedPost,result.getPosts());
    }

    @Test
    @DisplayName("T-0006-OK-Verificar el correcto ordenamiento descendente por fecha. (US-0009)")
    void getPostSellerListByUserIdDescendentOKTest() {
        //Arrange
        Integer id = 2;
        String order = "date_desc";
        List<PostDto> expectedPost = List.of(postDto2, postDto1);

        //Mock
        when(userService.getFollowedByUserId(id)).thenReturn(u1.getFollowed());

        //Act
        PostDtoRes result = postService.getPostSellerListByUserId(id, order);

        //Assert
        assertEquals(expectedPost,result.getPosts());
    }
}
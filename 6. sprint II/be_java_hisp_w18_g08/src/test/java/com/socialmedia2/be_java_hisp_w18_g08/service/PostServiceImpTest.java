package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.PostDtoRes;
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

    Seller s1;
    Seller s2;
    User u1;
    User u2;
    List<User> users = new ArrayList<>();
    List<Seller> sellers = new ArrayList<>();

    @BeforeEach
    private void setup() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("20-11-2022", formatter);

        List<Post> p1 = new ArrayList<>();
        List<User> followers = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();
        Product pr1;
        Product pr2;

        s1 = new Seller(1, "Seller1", followed, p1, followers);
        s2 = new Seller(2, "Seller2", followed, p1, followers);

        u1 = new User(4,"User1",followed);
        u2 = new User(5,"User2",followed);

        pr1 = new Product(1,"Silla","Oficina","Reclinable","Negro","Silla para oficina");
        pr2 = new Product(2,"Vaso","Utensilio","Termico","Negro","Vaso termico");

        Post post1 = new Post(1,1,pr1,1,4000.0,date);
        Post post2 = new Post(2,2,pr2,2,1000.0,date.plusDays(7));

        p1.add(post1);
        p1.add(post2);

        followers.add(u1);
        followers.add(u2);

        followed.add(s1);
        followed.add(s2);

        sellers.add(s1);
        sellers.add(s2);

        users.add(u1);
        users.add(u2);
    }

    @Test
    void create() {
    }

    @Test
    @DisplayName("T-0005-OK")
    void getPostSellerListByUserIdOKTest() {
        //Arrange
        Integer id = 4;
        String order = "date_asc";

        //Mock
        when(userService.getFollowedByUserId(id)).thenReturn(u1.getFollowed());

        //Act
        PostDtoRes result = postService.getPostSellerListByUserId(id, order);

        //Assert
        assertTrue(result != null);
        // assertDoesNotThrow(() -> postService.getPostSellerListByUserId(u1.getUser_id(), null));
    }

    @Test
    @DisplayName("T-0005-NoOK")
    void getPostSellerListByUserIdNoOKTest() {
        //Arrange
        Integer id = 4;
        String order = "sin_orden";

        //Mock
        when(userService.getFollowedByUserId(id)).thenReturn(u1.getFollowed());

        //Act
        //PostDtoRes result = postService.getPostSellerListByUserId(id, order);

        //Assert
        //assertTrue(result != null);
        assertThrows(NotFoundUserException.class, () -> postService.getPostSellerListByUserId(id, order));
    }
}
package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.PostDto;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.PostDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.ProductDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Post;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Product;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.entity.User;
import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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

    @Test
    void create() {
    }

    @Test
    @DisplayName("T-0008 - Verificar que la lista de post sea efectivamente de las últimas dos semanas. (US-0006)")
    void getPostSellerListByUserId() {
        //Arrange
        List<PostDto> posts = new ArrayList<>();
        List<Seller> followed = new ArrayList<>();
        List<User> followers = new ArrayList<>();
        List<Post> posts5 = new ArrayList<>();

        Seller s1 = new Seller(5, "User5", followed, posts5, followers);
        User u1 = new User(1, "User1", followed);
        followers.add(u1);
        followed.add(s1);

        ProductDtoRes prod1 = new ProductDtoRes();
        Product prod5 = new Product();
        PostDto p1 = new PostDto(1,5,prod1,12,133.33,LocalDate.now());
        Post post1 = new Post(1,5,prod5,12,133.33,LocalDate.now());

        posts5.add(post1);
        posts.add(p1);

        PostDtoRes expected = new PostDtoRes();
        expected.setPosts(posts);
        expected.setUser_id(1);

        when(userService.getFollowedByUserId(u1.getUser_id())).thenReturn(u1.getFollowed());

       //Act
        PostDtoRes result = postService.getPostSellerListByUserId(u1.getUser_id(),null);

        //Assert
        assertEquals(expected.getPosts(),result.getPosts());

    }
}
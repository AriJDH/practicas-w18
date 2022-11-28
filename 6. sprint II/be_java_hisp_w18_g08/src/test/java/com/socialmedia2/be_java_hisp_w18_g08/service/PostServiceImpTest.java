package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.repository.PostRepositoryImp;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PostServiceImpTest {

    //Revisar si realmente hacen falta los dos repos

    @Mock
    UserRepositoryImp userRepo;
    @Mock
    PostRepositoryImp postRepo;

    @InjectMocks
    UserServiceImp userService;
    @InjectMocks
    PostServiceImp postService;

    @Test
    void create() {
    }

    @Test
    void getPostSellerListByUserId() {
    }
}
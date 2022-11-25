package com.meli.be_java_hisp_w18_g9.unit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.repository.IPostRepository;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.service.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    // ? ================= Attributes ================= ?

    @Mock
    private IPostRepository postRepository;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private PostService postService;

    // ? ================= Tests ================= ?

    @Test
    void addPost() {
    }

    // * ============= *

    @Test
    void findAll() {
    }

    // * ============= *

    @Test
    void findPostsByFollowedAndUserId() {
    }

    // * ============= *

    @Test
    void findPostsByFollowedAndUserIdOrderByDateAsc() {
    }

    // * ============= *

    @Test
    void findPostsByFollowedAndUserIdOrderByDateDesc() {
    }

    // * ============= *
}
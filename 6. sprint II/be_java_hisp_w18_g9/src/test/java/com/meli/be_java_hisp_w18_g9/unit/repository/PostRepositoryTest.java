package com.meli.be_java_hisp_w18_g9.unit.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    // ? =============== Attributes =============== ?

    @Autowired
    private PostRepository postRepository;

    // ? =============== Before =============== ?

    @BeforeEach
    void setUp() {
        Post post = new Post(null, 1, LocalDate.now(), new Product(), 1, 10.0, true, 5.0);
        postRepository.addPost(post);
    }

    // ? =============== Tests =============== ?

    @Test
    @DisplayName("Save post")
    void addPost() {

        assertEquals(1, postRepository.findAll().size());
        assertNotNull(postRepository.findAll().get(0));
        assertFalse(postRepository.findAll().isEmpty());

    }

    // * ===============

    @Test
    @DisplayName("Get all posts")
    void findAll() {

        Post post = new Post(null, 1, LocalDate.now(), new Product(), 1, 10.0, true, 5.0);
        postRepository.addPost(post);

        assertTrue(postRepository.findAll().size() > 0);
        assertNotNull(postRepository.findAll().get(0));
        assertFalse(postRepository.findAll().isEmpty());

    }

    // * ===============

    @Test
    @DisplayName("Get all posts by Id")
    void findAllById() {

        Post post = new Post(null, 1, LocalDate.now(), new Product(), 1, 10.0, true, 5.0);
        postRepository.addPost(post);

        assertEquals(1, postRepository.findAllById(1).size());
        assertNotNull(postRepository.findAllById(1).get(0));
        assertFalse(postRepository.findAllById(1).isEmpty());

    }

    // * ===============

    @Test
    @DisplayName("Get post by Id")
    void findById() {

        Post post = new Post(null, 1, LocalDate.now(), new Product(), 1, 10.0, true, 5.0);
        postRepository.addPost(post);

        assertNotNull(postRepository.findById(1));

    }

    // * ===============
}
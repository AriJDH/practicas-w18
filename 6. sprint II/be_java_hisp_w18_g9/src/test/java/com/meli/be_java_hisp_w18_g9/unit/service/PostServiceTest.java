package com.meli.be_java_hisp_w18_g9.unit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9.model.dto.response.PostListByFollowedResponse;
import com.meli.be_java_hisp_w18_g9.model.entity.Post;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.model.entity.User;
import com.meli.be_java_hisp_w18_g9.repository.IPostRepository;
import com.meli.be_java_hisp_w18_g9.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9.service.PostService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostServiceTest {

    // ? ================= Attributes ================= ?

    @Mock
    private IPostRepository postRepository;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private static ObjectMapper mapper;

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
    @DisplayName("[T005] - Method for getting all posts from followed by user id (Happy Path)")
    void findPostsByFollowedAndUserId() {

        User userMock = new User(1, "User 1", new ArrayList<>(), List.of(
            new User(2, "User 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        ), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(userMock));
        when(postRepository.findAllById(anyInt())).thenReturn(List.of(
            new Post(1, 2, LocalDate.now(), new Product(1, "Product 1", "Type 1", "Brand 1", "Color 1", "Note 1"), 1, 10.0, true, 5.0),
            new Post(2, 2, LocalDate.now(), new Product(2, "Product 2", "Type 2", "Brand 2", "Color 1", "Note 2"), 1, 10.0, true, 5.0)
        ));

        when(mapper.convertValue(any(Post.class), eq(PostDtoRequest.class))).then(invocation -> {
            Post post = invocation.getArgument(0);
            return new PostDtoRequest(post.getPostId(), post.getUserId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice());
        });

        PostListByFollowedResponse postLists = postService.findPostsByFollowedAndUserId(1);

        assertEquals(2, postLists.getPosts().size());
        assertNotNull(postLists);

    }

    // * ============= *

    @Test
    @DisplayName("[T005] - Method for getting all posts from followed by user id (Sad Path - User not found)")
    void findPostsByFollowedAndUserIdUserNotFound() {
        //when(userRepository.findById(anyInt())).thenThrow(new NotFoundException("User not found"));
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        NotFoundException Exception = assertThrows(NotFoundException.class, () -> postService.findPostsByFollowedAndUserId(1));
        assertEquals("User with id 1 not found", Exception.getMessage());
    }

    // * ============= *
    PostListByFollowedResponse mockPostList(int order){
        User userMock = new User(1, "User 1", new ArrayList<>(), List.of(
                new User(2, "User 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        ), new ArrayList<>());

        when(userRepository.findById(1)).thenReturn(Optional.of(userMock));
        when(postRepository.findAllById(anyInt())).thenReturn(List.of(
                new Post(1, 2, LocalDate.now(), new Product(1, "Product 1", "Type 1", "Brand 1", "Color 1", "Note 1"), 1, 10.0, true, 5.0),
                new Post(2, 2, LocalDate.now().minusDays(10), new Product(2, "Product 2", "Type 2", "Brand 2", "Color 1", "Note 2"), 1, 10.0, true, 5.0)
        ));

        when(mapper.convertValue(any(Post.class), eq(PostDtoRequest.class))).then(invocation -> {
            Post post = invocation.getArgument(0);
            return new PostDtoRequest(post.getPostId(), post.getUserId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice());
        });
        PostListByFollowedResponse postLists;
        switch(order){
            case 1:
                postLists = postService.findPostsByFollowedAndUserIdOrderByDateAsc(1);
                break;
            case -1:
                postLists = postService.findPostsByFollowedAndUserIdOrderByDateDesc(1);
                break;
            default:
                postLists = postService.findPostsByFollowedAndUserId(1);
                break;
        }

        return postLists;
    }
    @Test
    @DisplayName("[T006] - Method for getting all posts from followed by user id ordered by date asc (Happy Path)")
    void findPostsByFollowedAndUserIdOrderByDateAsc() {
        PostListByFollowedResponse postLists = mockPostList(1);
        assertNotNull(postLists);
        assertEquals(postLists.getPosts().get(0).getDate(), LocalDate.now().minusDays(10));
        assertEquals(2, postLists.getPosts().size());
    }

    // * ============= *

    @Test
    @DisplayName("[T006] - Method for getting all posts from followed by user id ordered by date desc (Happy Path)")
    void findPostsByFollowedAndUserIdOrderByDateDesc() {
        PostListByFollowedResponse postLists = mockPostList(-1);
        assertNotNull(postLists);
        assertEquals(postLists.getPosts().get(0).getDate(), LocalDate.now());
        assertEquals(2, postLists.getPosts().size());
    }

    // * ============= *
}
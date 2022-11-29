package com.meli.be_java_hisp_w18_g9_camacho_ovalle.unit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.request.PostDtoRequest;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.PostDtoResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.dto.response.PostListByFollowedResponse;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Post;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Product;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.User;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.IPostRepository;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository.IUserRepository;
import com.meli.be_java_hisp_w18_g9_camacho_ovalle.service.PostService;
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
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        NotFoundException Exception = assertThrows(NotFoundException.class, () -> postService.findPostsByFollowedAndUserId(1));
        assertEquals("User with id 1 not found", Exception.getMessage());
    }

    // * ============= *

    private PostListByFollowedResponse mockPostList(int order){
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

    // * ============= *

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

    @Test
    @DisplayName("Find all posts")
    void findAll() {

        when(postRepository.findAll()).thenReturn(List.of(
                new Post(1, 2, LocalDate.now(), new Product(1, "Product 1", "Type 1", "Brand 1", "Color 1", "Note 1"), 1, 10.0, true, 5.0),
                new Post(2, 2, LocalDate.now().minusDays(10), new Product(2, "Product 2", "Type 2", "Brand 2", "Color 1", "Note 2"), 1, 10.0, true, 5.0)
        ));

        List<PostDtoResponse> postLists = postService.findAll();

        assertAll(() ->{
            assertEquals(2, postLists.size());
            assertNotNull(postLists);
        });
    }

    @Test
    @DisplayName("[T008] Verify that the consultation of publications made in the last two weeks of a certain seller")
    void findPostsByUserIdOrderByDateDesc() {
        //Arrange
        Integer userId = 1;

        //Mock
        User userMock = new User(1, "User 1", new ArrayList<>(), List.of(
                new User(2, "User 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        ), new ArrayList<>());

        when(userRepository.findById(userId)).thenReturn(Optional.of(userMock));

        List<Post> posts = List.of(
                new Post(1, 2, LocalDate.now(), new Product(1, "Product 1", "Type 1", "Brand 1", "Color 1", "Note 1"), 1, 10.0, true, 1.0),
                new Post(2, 2, LocalDate.now().minusDays(5), new Product(2, "Product 2", "Type 2", "Brand 2", "Color 1", "Note 2"), 1, 10.0, true, 1.0),
                new Post(3, 2, LocalDate.now().minusDays(30), new Product(3, "Product 3", "Type 3", "Brand 3", "Color 1", "Note 3"), 1, 10.0, true, 1.0)
        );

        when(postRepository.findAllById(anyInt())).thenReturn(posts);

        when(mapper.convertValue(any(Post.class), eq(PostDtoRequest.class))).then(invocation -> {
            Post post = invocation.getArgument(0);
            return new PostDtoRequest(post.getPostId(), post.getUserId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice());
        });

        //Action
        PostListByFollowedResponse postLists = postService.findPostsByFollowedAndUserIdOrderByDateDesc(userId);

        //Assert
        assertEquals(2, postLists.getPosts().size());
        assertEquals(LocalDate.now(), postLists.getPosts().get(0).getDate());

    }

    // * ============= *

    @Test
    @DisplayName("[T008] Verify that the consultation of publications made in the last two weeks of a certain seller")
    void findPostsByUserIdOrderByDateAsc() {
        //Arrange
        Integer userId = 1;

        //Mock
        User userMock = new User(1, "User 1", new ArrayList<>(), List.of(
                new User(2, "User 2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>())
        ), new ArrayList<>());

        when(userRepository.findById(userId)).thenReturn(Optional.of(userMock));

        List<Post> posts = List.of(
                new Post(1, 2, LocalDate.now(), new Product(1, "Product 1", "Type 1", "Brand 1", "Color 1", "Note 1"), 1, 10.0, true, 1.0),
                new Post(2, 2, LocalDate.now().minusDays(5), new Product(2, "Product 2", "Type 2", "Brand 2", "Color 1", "Note 2"), 1, 10.0, true, 1.0),
                new Post( 3, 2, LocalDate.now().minusDays(16), new Product(3, "Product 3", "Type 3", "Brand 3", "Color 1", "Note 3"), 1, 10.0, true, 1.0));
        when(postRepository.findAllById(anyInt())).thenReturn(posts);

        when(mapper.convertValue(any(Post.class), eq(PostDtoRequest.class))).then(invocation -> {
            Post post = invocation.getArgument(0);
            return new PostDtoRequest(post.getPostId(), post.getUserId(), post.getDate(), post.getProduct(), post.getCategory(), post.getPrice());
        });

        //Action
        PostListByFollowedResponse postLists = postService.findPostsByFollowedAndUserIdOrderByDateAsc(userId);

        //Assert
        assertEquals(2, postLists.getPosts().size());
        assertEquals(LocalDate.now().minusDays(5), postLists.getPosts().get(0).getDate());


    }
}
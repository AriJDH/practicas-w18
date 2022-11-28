package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w18_g01.mappers.MapperPostToPostDTO;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    private UserDbService userDbService;
    @InjectMocks
    private PostServiceImpl postService;
    MapperPostToPostDTO mapperPostToPostDTO = new MapperPostToPostDTO();
    private User user1;
    private User user2;
    private Post post1;
    private Post post2;
    private Post post3;
    private Post post4;

    @BeforeEach
    public void cleanUsers(){
        user1 = new User(1L, "Lucas", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user2 = new User(2L, "Marcos", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        post1 = new Post(1L, user2, LocalDate.now(),new Product(), 1,10);
        post2 = new Post(2L, user2, LocalDate.of(2022,11,26),new Product(),100, 20000);
        post3 = new Post(3L, user2, LocalDate.of(2022,11,22),new Product(),100, 20000);
        post4 = new Post(4L, user2, LocalDate.of(2022,11,20),new Product(),100, 20000);
    }

    //T-0005
    @Test
    public void verifyOderTypeAscByDateExists(){
        user2.addPost(post1);
        user1.follow(user2);
        when(userDbService.findById(1L)).thenReturn(user1);

        assertDoesNotThrow(()->postService.getRecentPostsFromFollowed(1L, "date_asc"));
    }
    @Test
    public void verifyOderTypeDescByDateExists(){
        user2.addPost(post1);
        user1.follow(user2);
        when(userDbService.findById(1L)).thenReturn(user1);

        assertDoesNotThrow(()->postService.getRecentPostsFromFollowed(1L, "date_desc"));
    }
    @Test
    public void verifyOderTypeXDoesNotExist(){
        user2.addPost(post1);
        user1.follow(user2);
        when(userDbService.findById(1L)).thenReturn(user1);

        assertThrows(BadRequestException.class, ()->postService.getRecentPostsFromFollowed(1L, "un tipo nada que ver"));
    }
    //T-0006
    @Test
    public void checkAscOrderingByDate(){
        user2.addPost(post1);
        user2.addPost(post2);
        user2.addPost(post3);
        user2.addPost(post4);
        user1.follow(user2);
        List<Post> ascOrderedPosts = new ArrayList<>();
        ascOrderedPosts.add(post4);
        ascOrderedPosts.add(post3);
        ascOrderedPosts.add(post2);
        ascOrderedPosts.add(post1);
        List<PostDTO> ascOrderedPostDTOs = ascOrderedPosts.stream().map(post->mapperPostToPostDTO.convertValue(post, PostDTO.class)).collect(Collectors.toList());
        when(userDbService.findById(1L)).thenReturn(user1);

        assertEquals(postService.getRecentPostsFromFollowed(1L, "date_asc").get(0).getPosts(),ascOrderedPostDTOs);
    }
    @Test
    public void checkDescOrderingByDate(){
        user2.addPost(post1);
        user2.addPost(post2);
        user2.addPost(post3);
        user2.addPost(post4);
        user1.follow(user2);
        List<Post> descOrderedPosts = new ArrayList<>();
        descOrderedPosts.add(post1);
        descOrderedPosts.add(post2);
        descOrderedPosts.add(post3);
        descOrderedPosts.add(post4);
        List<PostDTO> descOrderedPostDTOs = descOrderedPosts.stream().map(post->mapperPostToPostDTO.convertValue(post, PostDTO.class)).collect(Collectors.toList());
        when(userDbService.findById(1L)).thenReturn(user1);

        assertEquals(postService.getRecentPostsFromFollowed(1L, "date_desc").get(0).getPosts(),descOrderedPostDTOs);
    }
    //T-0008
    @Test
    public void verifyPostsAreFromLast2Weeks(){

    }

}

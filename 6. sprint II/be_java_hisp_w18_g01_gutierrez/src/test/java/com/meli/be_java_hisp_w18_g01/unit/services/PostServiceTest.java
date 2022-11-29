package com.meli.be_java_hisp_w18_g01.unit.services;

import com.meli.be_java_hisp_w18_g01.dtos.PostDTO;
import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.BadRequestException;
import com.meli.be_java_hisp_w18_g01.mappers.MapperPostToPostDTO;
import com.meli.be_java_hisp_w18_g01.services.PostServiceImpl;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    public void initUsers(){
        user1 = new User(1L, "Lucas", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user2 = new User(2L, "Marcos", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        post1 = new Post(1L, user2, LocalDate.now(),new Product(), 1,10);
        post2 = new Post(2L, user2, LocalDate.now().minusDays(2),new Product(),100, 20000);
        post3 = new Post(3L, user2, LocalDate.now().minusDays(4),new Product(),100, 20000);
        post4 = new Post(4L, user2, LocalDate.now().minusDays(6),new Product(),100, 20000);
    }

    //T-0005
    @Test
    @DisplayName("T0005 - Verificación de tipo de orden válido por fecha ascendente")
    public void verifyOderTypeAscByDateExists(){
        //Arrange
        user2.addPost(post1);
        user1.follow(user2);

        //Mock
        when(userDbService.findById(1L)).thenReturn(user1);

        //Act
        assertDoesNotThrow(()->postService.getRecentPostsFromFollowed(1L, "date_asc"));
    }
    @Test
    @DisplayName("T0005 - Verificación de tipo de orden válido por fecha descendente")
    public void verifyOderTypeDescByDateExists(){
        //Arrange
        user2.addPost(post1);
        user1.follow(user2);

        //Mock
        when(userDbService.findById(1L)).thenReturn(user1);

        //Act-Assert
        assertDoesNotThrow(()->postService.getRecentPostsFromFollowed(1L, "date_desc"));
    }
    @Test
    @DisplayName("T0005 - Verificación de tipo de orden por fecha no existente")
    public void verifyOderTypeXDoesNotExist(){
        //Arrange
        user2.addPost(post1);
        user1.follow(user2);

        //Mock
        when(userDbService.findById(1L)).thenReturn(user1);

        //Act-Assert
        assertThrows(BadRequestException.class, ()->postService.getRecentPostsFromFollowed(1L, "un tipo nada que ver"));
    }
    //T-0006
    @Test
    @DisplayName("T0006 - Ordenamiento de posts por fecha ascendente")
    public void checkAscOrderingByDate(){
        //Arrange
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

        //Mock
        when(userDbService.findById(1L)).thenReturn(user1);

        //Act-Assert
        Assertions.assertArrayEquals(ascOrderedPostDTOs.toArray(),postService.getRecentPostsFromFollowed(1L, "date_asc").get(0).getPosts().toArray());
    }
    @Test
    @DisplayName("T0006 - Ordenamiento de posts por fecha descendente")
    public void checkDescOrderingByDate(){
        //Arrange
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
        List<PostDTO> descOrderedPostDTOs = descOrderedPosts.stream()
                .map(post->mapperPostToPostDTO.convertValue(post, PostDTO.class))
                .collect(Collectors.toList());

        //Mock
        when(userDbService.findById(1L)).thenReturn(user1);

        //Act-Assert
        Assertions.assertArrayEquals(descOrderedPostDTOs.toArray(),postService.getRecentPostsFromFollowed(
                        1L,
                        "date_desc")
                .get(0).getPosts().toArray());
    }
    //T-0008
    @Test
    @DisplayName("T0008 - Posts obtenidos son de las últimas dos semanas")
    public void verifyPostsAreFromLast2Weeks(){
        //Arrange
        Post post5 = new Post(4L, user2, LocalDate.now().minusMonths(2),new Product(),100, 20000);
        Post post6 = new Post(4L, user2, LocalDate.now().minusDays(15),new Product(),100, 20000);

        user2.addPost(post1);
        user2.addPost(post5);
        user2.addPost(post6);

        user1.follow(user2);

        List<PostDTO> descOrderedPostDTOs = new ArrayList<>();

        descOrderedPostDTOs.add(mapperPostToPostDTO.convertValue(post1, PostDTO.class));

        //Mock
        when(userDbService.findById(1L)).thenReturn(user1);

        //Act-Assert
        Assertions.assertArrayEquals(descOrderedPostDTOs.toArray(),postService.getRecentPostsFromFollowed(
                        1L,
                        "date_desc")
                .get(0).getPosts().toArray());
    }
}

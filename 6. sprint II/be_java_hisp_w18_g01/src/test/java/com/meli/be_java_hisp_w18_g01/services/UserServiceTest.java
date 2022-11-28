package com.meli.be_java_hisp_w18_g01.services;

import com.meli.be_java_hisp_w18_g01.entities.Post;
import com.meli.be_java_hisp_w18_g01.entities.Product;
import com.meli.be_java_hisp_w18_g01.entities.User;
import com.meli.be_java_hisp_w18_g01.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w18_g01.repositories.UserRepository;
import com.meli.be_java_hisp_w18_g01.services.UserService;
import com.meli.be_java_hisp_w18_g01.services.UserServiceImpl;
import com.meli.be_java_hisp_w18_g01.services.database.UserDbServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserDbServiceImpl userDbService;
    @Autowired
    private UserServiceImpl userService;
    private User user1 = new User(1L, "Lucas", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    private User user2 = new User(2L, "Marcos", new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    private Post post = new Post(1L, user2, LocalDate.now(),new Product(), 1,10);

    @BeforeEach
    public void configUserService(){
        userService.setUserDbService(userDbService);
    }

    //T-0001
    @Test
    public void checkUserToFollowExists(){
        user2.addPost(post);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user2));

        userService.handleFollow(1L,2L);

        assertTrue(user1.getFollowed().contains(user2));
    }
    @Test
    public void checkUserToFollowDoesNotExist(){
        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, ()->userService.handleFollow(1L,2L));
    }
    //T-0002
    @Test
    public void checkUserToUnfollowExists(){
        user2.addPost(post);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.of(user2));

        user1.follow(user2);
        userService.handleUnfollow(1L, 2L);

        assertFalse(user1.getFollowed().contains(user2));
    }
    @Test
    public void checkUserToUnfollowDoesNotExist(){
        user2.addPost(post);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, ()->userService.handleUnfollow(1L,2L));
    }
    //T-0003
    @Test
    public void verifyOderTypeAscExists(){

    }
    @Test
    public void verifyOderTypeDescExists(){

    }
    @Test
    public void verifyOderTypeXDoesNotExist(){

    }
    //T-0004
    @Test
    public void checkAscOrderingByName(){

    }
    @Test
    public void checkDescOrderingByName(){

    }
}

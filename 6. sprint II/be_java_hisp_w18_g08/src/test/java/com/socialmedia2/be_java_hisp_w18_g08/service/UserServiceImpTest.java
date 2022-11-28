package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowDtoRes;
import com.socialmedia2.be_java_hisp_w18_g08.dto.response.FollowedDto;
import com.socialmedia2.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImpTest {

    @Mock
    UserRepositoryImp userRepo;

    @InjectMocks
    UserServiceImp userService;


    @Test
    void follow() {
        //Arrange
        FollowDtoReq  followDtoReq = new FollowDtoReq(1,5);
        FollowDtoRes  followDtoRes = new FollowDtoRes();
        String expected = userRepo.follow(1,5);
        followDtoRes.setMessage(expected);
        followDtoRes.setStatusCode(200);
        when(userService.follow(followDtoReq)).thenReturn(followDtoRes);

        //act
        FollowDtoRes result = userService.follow(followDtoReq);

        //assert
        assertEquals(followDtoRes,result);
    }
}
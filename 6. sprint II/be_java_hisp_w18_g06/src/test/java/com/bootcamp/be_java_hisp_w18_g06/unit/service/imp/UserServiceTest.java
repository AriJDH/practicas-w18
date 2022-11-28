package com.bootcamp.be_java_hisp_w18_g06.unit.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.repository.imp.UserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.imp.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.getUserWithFollowedList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository repository;
    @InjectMocks
    UserService service;

    //US0001
    @Nested
    class T0001{
        @Test
        void followUser() {
        }
    }


    //US0007
    @Nested
    class T0002{
        @Test
        void unfollowUser() {
        }
    }
    //US-0008
    @Nested
    class T0003{
        @Test
        void getFollowedListOk() {
            String order = "name_asc";
            User user = getUserWithFollowedList("user with followed list");

            Mockito.when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
            Assertions.assertDoesNotThrow(()->service.getFollowedList(user.getUser_id(), order));

        }
        @Test
        void getFollowedListNotOk() {
            String order = "order not found";
            User user = getUserWithFollowedList("user with followed list");

            Mockito.when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
            Assertions.assertThrows(BadRequestException.class, ()->service.getFollowedList(user.getUser_id(), order));
        }
    }
    //US-0008
    @Nested
    class T0004{
        @Test
        void getFollowedList() {
        }
    }
    //US0002
    @Nested
    class T0007{
        @Test
        void getFollowersList() {
        }
    }

}
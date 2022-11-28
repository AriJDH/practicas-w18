package com.bootcamp.be_java_hisp_w18_g06.unit.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersListDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
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
        void getFollowedList() {
        }
    }
    //US-0008
    @Nested
    class T0004 {
        @Test
        void getFollowedListAsc() {
            String order = "name_asc";
            User user = getUserWithFollowedList("user with followed list asc");

            Mockito.when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));

            UserFollowedListDTO result = service.getFollowedList(user.getUser_id(), order);
            Assertions.assertEquals("user 1", result.getFollowed().get(0).getUser_name());
        }

        @Test
        void getFollowedListDesc() {
            String order = "name_desc";
            User user = getUserWithFollowedList("user with followed list desc");

            Mockito.when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));

            UserFollowedListDTO result = service.getFollowedList(user.getUser_id(), order);
            Assertions.assertEquals("user 3", result.getFollowed().get(0).getUser_name());
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
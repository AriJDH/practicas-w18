package com.bootcamp.be_java_hisp_w18_g06.unit.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    UserFactory userFactory;

    //US0001
    @Nested
    class T0001{
        @DisplayName("FollowUserOK")
        @Test
        void verifyUserToFollowExistsOk() {
           //verificar que el usuario a seguir exista
        }

        @DisplayName("FollowUserNotOK")
        @Test
        void followUserNotOk() {
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
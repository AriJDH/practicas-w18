package com.bootcamp.be_java_hisp_w18_g06.unit.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.repository.imp.UserRepository;
import com.bootcamp.be_java_hisp_w18_g06.service.imp.UserService;
import com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Optional;

import static com.bootcamp.be_java_hisp_w18_g06.utils.UserFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
class UserServiceTest {

    @Mock
    UserRepository repository;
    @InjectMocks
    UserService service;

    //US0001
    @Nested
    class T0001{
        @Test
        void verifyUserToFollowExistsOkTest() { // :)
           //verificar que el usuario a seguir exista
            //ARRANGE
            User user = getUserWithFollowersListAndPosts("mockFollowed");
            //MOCK
            when(repository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
            //ASSERT
            assertEquals(user, repository.findUserById(user.getUserId()).get());
            Assertions.assertTrue(service.userFollowedHasPosts(user));
          //  Assertions.assertDoesNotThrow(()->service.followUser(user2.getUser_id(), user.getUser_id()));

        }

        @DisplayName("FollowUserNotOK")
        @Test
        void userToFollowDoesntExistsOk() {
            //El usuario a seguir NO EXISTE
            // ARRANGE
            int idUnexists = 509;
            //MOCK
            when(repository.findUserById(idUnexists)).thenReturn(Optional.empty());
            //ASSERT
            assertEquals(Optional.empty(),repository.findUserById(idUnexists));
            Assertions.assertFalse(service.userIsPresent(idUnexists));

        }
    }



    //US0007
    @Nested
    class T0002{
        @Test
        void verifyUserToUnfollowExistsOkTest() {
            //verificar que el usuario a dejar seguir exista
            //ARRANGE

            User userToUnfollow = getUserWithFollowersListAndPosts("userToUnfollow");
            User userFollower = userToUnfollow.getFollowers().get(0);
            userFollower.setFollowed(Collections.singletonList(userToUnfollow));

            //MOCK
            when(repository.findUserById(userFollower.getUserId())).thenReturn(Optional.of(userFollower));
            when(repository.findUserById(userToUnfollow.getUserId())).thenReturn(Optional.of(userToUnfollow));


            when(repository.findUserInList(userFollower.getFollowed(),userToUnfollow.getUserId())).thenReturn(Optional.of(userToUnfollow));
            when(repository.findUserInList(userToUnfollow.getFollowers(),userFollower.getUserId())).thenReturn(Optional.of(userFollower));

            //ACT, ASSERT

            Assertions.assertDoesNotThrow(()->service.unfollowUser(userFollower.getUserId(), userToUnfollow.getUserId()));

            verify(repository,atLeast(2)).findUserById(anyInt());
            verify(repository,atLeast(2)).findUserInList(anyList(),anyInt());

        }

        @Test
        void verifyUserToUnfollowExistsExceptionTest() {
            //verificar que el usuario a dejar seguir no exista en la lista del userFollower
            //ARRANGE

            User userToUnfollow = getUserWithFollowersListAndPosts("userToUnfollow");
            userToUnfollow.setUserId(1);
            User userFollower = userToUnfollow.getFollowers().get(0);
            userFollower.setFollowed(Collections.singletonList(userToUnfollow));

            //MOCK
            when(repository.findUserById(userFollower.getUserId())).thenReturn(Optional.of(userFollower));
            when(repository.findUserById(userToUnfollow.getUserId())).thenReturn(Optional.of(userToUnfollow));

            when(repository.findUserInList(userFollower.getFollowed(),userToUnfollow.getUserId())).thenReturn(Optional.empty());
            when(repository.findUserInList(userToUnfollow.getFollowers(),userFollower.getUserId())).thenReturn(Optional.empty());

            //ACT, ASSERT
            Assertions.assertThrows(BadRequestException.class, ()->service.unfollowUser(userFollower.getUserId(), userToUnfollow.getUserId()));

            verify(repository,atLeast(2)).findUserById(anyInt());
            verify(repository,atLeast(2)).findUserInList(anyList(),anyInt());
        }
    }
    //US-0008
    @Nested
    class T0003{
        @Test
        void getFollowedListOk() {
            String order = "name_asc";
            User user = getUserWithFollowedList("user with followed list");

            when(repository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
            Assertions.assertDoesNotThrow(()->service.getFollowedList(user.getUserId(), order));

        }
        @Test
        void getFollowedListNotOk() {
            String order = "order not found";
            User user = getUserWithFollowedList("user with followed list");

            when(repository.findUserById(user.getUserId())).thenReturn(Optional.of(user));
            Assertions.assertThrows(BadRequestException.class, ()->service.getFollowedList(user.getUserId(), order));
        }
    }
    //US-0008
    @Nested
    class T0004 {
        @Test
        void getFollowedListAsc() {
            String order = "name_asc";
            User user = getUserWithFollowedList("user with followed list asc");

            when(repository.findUserById(user.getUserId())).thenReturn(Optional.of(user));

            UserFollowedListDTO result = service.getFollowedList(user.getUserId(), order);
            assertEquals("user 1", result.getFollowed().get(0).getUserName());
        }

        @Test
        void getFollowedListDesc() {
            String order = "name_desc";
            User user = getUserWithFollowedList("user with followed list desc");

            when(repository.findUserById(user.getUserId())).thenReturn(Optional.of(user));

            UserFollowedListDTO result = service.getFollowedList(user.getUserId(), order);
            assertEquals("user 3", result.getFollowed().get(0).getUserName());
        }
    }
    //US0002
    @Nested
    class T0007 {
        
        // Testear que devuelva la cantidad correcta de usuarios
        @Test
        @DisplayName("US0002/T0007 - Calcula correctamente la cantidad total de seguidores")
        void getFollowersListOkTest() {
            
            // ARRANGE
            User user = UserFactory.getUserWithFollowersList("user1");
            
            //MOCKS - ACT
            when(repository.findUserById(1))
                    .thenReturn(Optional.of(user));
            
            UserFollowersCountDTO userFollowersCountDTO = new UserFollowersCountDTO();
            userFollowersCountDTO.setFollowersCount(3);
            
            // ASSERTS
            assertEquals(userFollowersCountDTO.getFollowersCount(),
                         service.getFollowersCount(1).getFollowersCount());
            
        }
    }

}
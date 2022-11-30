package com.bootcamp.be_java_hisp_w18_g06.unit.service.imp;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersListDTO;
import com.bootcamp.be_java_hisp_w18_g06.entity.User;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.BadRequestException;
import com.bootcamp.be_java_hisp_w18_g06.exceptions.EmptyException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
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
            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
            //ASSERT
            assertEquals(user, repository.findUserById(user.getUser_id()).get());
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
            when(repository.findUserById(userFollower.getUser_id())).thenReturn(Optional.of(userFollower));
            when(repository.findUserById(userToUnfollow.getUser_id())).thenReturn(Optional.of(userToUnfollow));


            when(repository.findUserInList(userFollower.getFollowed(),userToUnfollow.getUser_id())).thenReturn(Optional.of(userToUnfollow));
            when(repository.findUserInList(userToUnfollow.getFollowers(),userFollower.getUser_id())).thenReturn(Optional.of(userFollower));

            //ACT, ASSERT

            Assertions.assertDoesNotThrow(()->service.unfollowUser(userFollower.getUser_id(), userToUnfollow.getUser_id()));

            verify(repository,atLeast(2)).findUserById(anyInt());
            verify(repository,atLeast(2)).findUserInList(anyList(),anyInt());

        }

        @Test
        void verifyUserToUnfollowExistsExceptionTest() {
            //verificar que el usuario a dejar seguir no exista en la lista del userFollower
            //ARRANGE

            User userToUnfollow = getUserWithFollowersListAndPosts("userToUnfollow");
            userToUnfollow.setUser_id(1);
            User userFollower = userToUnfollow.getFollowers().get(0);
            userFollower.setFollowed(Collections.singletonList(userToUnfollow));

            //MOCK
            when(repository.findUserById(userFollower.getUser_id())).thenReturn(Optional.of(userFollower));
            when(repository.findUserById(userToUnfollow.getUser_id())).thenReturn(Optional.of(userToUnfollow));

            when(repository.findUserInList(userFollower.getFollowed(),userToUnfollow.getUser_id())).thenReturn(Optional.empty());
            when(repository.findUserInList(userToUnfollow.getFollowers(),userFollower.getUser_id())).thenReturn(Optional.empty());

            //ACT, ASSERT
            Assertions.assertThrows(BadRequestException.class, ()->service.unfollowUser(userFollower.getUser_id(), userToUnfollow.getUser_id()));

            verify(repository,atLeast(2)).findUserById(anyInt());
            verify(repository,atLeast(2)).findUserInList(anyList(),anyInt());
        }
        @Test
        void UserToUnfollowEqualsIdsExceptionTest() {
            //verificar que el usuario a dejar seguir no exista en la lista del userFollower
            //ARRANGE

            User userToUnfollow = getUserWithFollowersListAndPosts("userToUnfollow");
            userToUnfollow.setUser_id(1);
            User userFollower = userToUnfollow.getFollowers().get(0);
            userFollower.setFollowed(Collections.singletonList(userToUnfollow));

            userFollower.setUser_id(1);

            //MOCK
            when(repository.findUserById(userFollower.getUser_id())).thenReturn(Optional.of(userFollower));
            when(repository.findUserById(userToUnfollow.getUser_id())).thenReturn(Optional.of(userToUnfollow));

            when(repository.findUserInList(userFollower.getFollowed(),userToUnfollow.getUser_id())).thenReturn(Optional.of(userToUnfollow));
            when(repository.findUserInList(userToUnfollow.getFollowers(),userFollower.getUser_id())).thenReturn(Optional.of(userFollower));

            //ACT, ASSERT
            Assertions.assertThrows(BadRequestException.class, ()->service.unfollowUser(userFollower.getUser_id(), userToUnfollow.getUser_id()));

        }
        @Test
        void UserToUnfollowSellerNotPresentExceptionTest() {
            //verificar que el usuario a dejar seguir no exista en la lista del userFollower
            //ARRANGE

            User userToUnfollow = getUserWithFollowersListAndPosts("userToUnfollow");
            userToUnfollow.setUser_id(1);
            User userFollower = userToUnfollow.getFollowers().get(0);
            userFollower.setFollowed(Collections.singletonList(userToUnfollow));

            userFollower.setUser_id(1);

            //MOCK
            when(repository.findUserById(userFollower.getUser_id())).thenReturn(Optional.empty());
            when(repository.findUserById(userToUnfollow.getUser_id())).thenReturn(Optional.of(userToUnfollow));

            when(repository.findUserInList(userFollower.getFollowed(),userToUnfollow.getUser_id())).thenReturn(Optional.of(userToUnfollow));
            when(repository.findUserInList(userToUnfollow.getFollowers(),userFollower.getUser_id())).thenReturn(Optional.of(userFollower));

            //ACT, ASSERT
            Assertions.assertThrows(BadRequestException.class, ()->service.unfollowUser(userFollower.getUser_id(), userToUnfollow.getUser_id()));

        }
    }
    //US-0008
    @Nested
    class T0003{
        @Test
        void getFollowedListOk() {
            String order = "name_asc";
            User user = getUserWithFollowedList("user with followed list");

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
            Assertions.assertDoesNotThrow(()->service.getFollowedList(user.getUser_id(), order));

        }
        @Test
        void getFollowedListNotOk() {
            String order = "order not found";
            User user = getUserWithFollowedList("user with followed list");

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
            Assertions.assertThrows(BadRequestException.class, ()->service.getFollowedList(user.getUser_id(), order));
        }
        @Test
        void getFollowedListEmptyExceptionTest() {

            User user = getUserWithFollowedList("user with followed list");
            user.setFollowed(null);

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
            Assertions.assertThrows(EmptyException.class, ()->service.getFollowedList(user.getUser_id(), null));
        }
        @Test
        void getFollowedListDescTest() {
            String order = "name_desc";
            User user = getUserWithFollowedList("user with followed list");

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));
            Assertions.assertDoesNotThrow(()->service.getFollowedList(user.getUser_id(), order));

        }

    }
    //US-0008
    @Nested
    class T0004 {
        @Test
        void getFollowedListAsc() {
            String order = "name_asc";
            User user = getUserWithFollowedList("user with followed list asc");

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));

            UserFollowedListDTO result = service.getFollowedList(user.getUser_id(), order);
            assertEquals("user 1", result.getFollowed().get(0).getUser_name());
        }

        @Test
        void getFollowedListDesc() {
            String order = "name_desc";
            User user = getUserWithFollowedList("user with followed list desc");

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));

            UserFollowedListDTO result = service.getFollowedList(user.getUser_id(), order);
            assertEquals("user 3", result.getFollowed().get(0).getUser_name());
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
            userFollowersCountDTO.setFollowers_count(3);
            
            // ASSERTS
            assertEquals(userFollowersCountDTO.getFollowers_count(),
                         service.getFollowersCount(1).getFollowers_count());
            
        }

        @Test
        void getFollowersCountEmptyExceptionTest() {

            // ARRANGE
            User user = UserFactory.getUserWithFollowersList("user1");
            user.setFollowers(null);

            //MOCKS - ACT
            when(repository.findUserById(user.getUser_id()))
                    .thenReturn(Optional.of(user));

            // ACT  ASSERTS
            assertThrows(EmptyException.class,()->service.getFollowersCount(user.getUser_id()));

        }
        @Test
        void getFollowerListAscTest() {
            String order = "name_asc";
            User user = getUserWithFollowersList("user with followed list asc");

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));

            UserFollowersListDTO result = service.getFollowersList(user.getUser_id(), order);
            assertEquals("user 1", result.getFollowers().get(0).getUser_name());
        }

        @Test
        void getFollowerListDescTest() {
            String order = "name_desc";
            User user = getUserWithFollowersList("user with followed list asc");

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));

            UserFollowersListDTO result = service.getFollowersList(user.getUser_id(), order);
            assertEquals("user 3", result.getFollowers().get(0).getUser_name());
        }
        @Test
        void getFollowerListExceptionTest() {
            String order = "Bad request";
            User user = getUserWithFollowersList("user with followed list asc");

            when(repository.findUserById(user.getUser_id())).thenReturn(Optional.of(user));

            assertThrows(BadRequestException.class,()->service.getFollowersList(user.getUser_id(), order));
        }
    }

}
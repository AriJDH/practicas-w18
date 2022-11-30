package com.example.socialmeli2.unit.service;

import com.example.socialmeli2.dto.response.UserBasicResponse;
import com.example.socialmeli2.dto.response.UserFollowerCountResponse;
import com.example.socialmeli2.dto.response.UserFollowersListResponse;
import com.example.socialmeli2.entity.UserEntity;
import com.example.socialmeli2.exception.NotFoundException;
import com.example.socialmeli2.repository.IUserRepository;
import com.example.socialmeli2.service.UserServiceImpl;
import com.example.socialmeli2.util.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    @Nested
    @DisplayName("T-0001 - Verify that the user to follow exists")
    class FollowUserSeller {

        //Arrange
        Integer userId = 3;
        Integer sellerId = 4;

        @Test
        @DisplayName("Success")
        void test1() {

            //Arrange
            boolean expected = true;

            //Mock
            Mockito.when(userRepository.exist(userId)).thenReturn(true);
            Mockito.when(userRepository.exist(sellerId)).thenReturn(true);
            Mockito.when(userRepository.isSeller(sellerId)).thenReturn(true);

            //Act
            boolean response = userService.followUserSeller(userId, sellerId);

            //Assert
            Assertions.assertEquals(expected, response);

        }

        @Test
        @DisplayName("Not Success - User does not Exists")
        void test2() {

            //Mock
            Mockito.when(userRepository.exist(userId)).thenReturn(false);

            //Act y Assert
            Assertions.assertThrows(NotFoundException.class, () -> userService.followUserSeller(userId, sellerId));

        }

        @Test
        @DisplayName("Not Success - Seller does not Exists")
        void test3() {

            //Mockito
            Mockito.lenient().when(userRepository.exist(userId)).thenReturn(true);
            Mockito.lenient().when(userRepository.exist(sellerId)).thenReturn(false);

            //Act y Assert
            Assertions.assertThrows(NotFoundException.class, () -> userService.followUserSeller(userId, sellerId));

        }

        @Test
        @DisplayName("Not Success - User to follow is not a Seller")
        void test4() {

            //Mockito
            Mockito.lenient().when(userRepository.exist(userId)).thenReturn(true);
            Mockito.lenient().when(userRepository.exist(sellerId)).thenReturn(true);
            Mockito.lenient().when(userRepository.isSeller(sellerId)).thenReturn(false);

            //Act y Assert
            Assertions.assertThrows(NotFoundException.class, () -> userService.followUserSeller(userId, sellerId));

        }
    }

    @Nested
    @DisplayName("T-0002 - Verify that the user to be unfollowed exists")
    class unfollowUserSeller {

        @Test
        @DisplayName("Success")
        void test1() {

            //Arrange
            int userId = 10;
            String userName = "Gloria";
            int userIdToUnfollow = 22;

            //Mock
            Mockito.when(userRepository.exist(userId)).thenReturn(true);
            Mockito.when(userRepository.exist(userIdToUnfollow)).thenReturn(true);
            Mockito.when(userRepository.getEntityById(userId)).thenReturn(UserFactory.getUserWithFollowers(userIdToUnfollow, userName));

            //Act
            boolean ifExist = userService.unfollowUserSeller(userId, userIdToUnfollow);

            //Assert
            assertTrue(ifExist);

        }

        @Test
        @DisplayName("Not Success - User does not Exists")
        void test2() {

            //Arrange
            int userId = 5;
            String userName = "Gloria";
            int userIdToUnfollow = 0;

            //Mock
            Mockito.when(userRepository.exist(userId)).thenReturn(true);
            Mockito.when(userRepository.exist(userIdToUnfollow)).thenReturn(true);
            Mockito.when(userRepository.getEntityById(userId)).thenReturn(UserFactory.getUserWithFollowers(userIdToUnfollow, userName));

            //Act
            boolean ifExist = userService.unfollowUserSeller(userId, userIdToUnfollow);

            //Assert
            assertFalse(ifExist);

        }

        @Test
        @DisplayName("Exception - User to unfollow does not Exists")
        void test3() {

            //Arrange
            int userId = 1;
            int userIdToUnfollow = 10;

            //Mock
            Mockito.when(userRepository.exist(userId)).thenReturn(true);

            //Act & Assert
            assertThrows(NotFoundException.class, () -> userService.unfollowUserSeller(userId, userIdToUnfollow));

        }
    }

    @Nested
    @DisplayName("T-0004 - correct ordering by name")
    class getFollowersUsersById {

        @Test
        @DisplayName("Success - Order ASC by name")
        void test1() {

            // Arrange
            /* Params */
            Integer userId = 1;
            String order = "name_asc";
            /* Variables */
            String userName = "Bean";
            /* Expected */
            List<UserBasicResponse> userBasicResponseList = new ArrayList<>();
            for (UserEntity userEntity : UserFactory.getUserListOrderedAsc()) {
                userBasicResponseList.add(new UserBasicResponse(userEntity.getId(), userEntity.getName()));
            }
            UserFollowersListResponse expected = new UserFollowersListResponse(userId, userName, userBasicResponseList);

            // Mock
            /* Mock of seller user entity */
            UserEntity seller = UserFactory.getUserWithFollowers(userId, userName);
            Mockito.when(userRepository.getEntityById(userId))
                    .thenReturn(seller);
            /* Mock of followers user entities */
            List<UserEntity> userListUnordered = UserFactory.getUserListUnordered();
            for (UserEntity userEntity : userListUnordered) {
                Mockito.when(userRepository.getEntityById(userEntity.getId()))
                        .thenReturn(userEntity);
            }

            // Act
            UserFollowersListResponse result = userService.getFollowersUsersById(userId, order);

            // Assert
            Assertions.assertEquals(expected, result);

        }

        @Test
        @DisplayName("Success - Order DESC by name")
        void test2() {

            // Arrange
            /* Params */
            Integer userId = 1;
            String order = "name_desc";
            /* Variables */
            String userName = "Bean";
            /* Expected */
            List<UserBasicResponse> userBasicResponseList = new ArrayList<>();
            for (UserEntity userEntity : UserFactory.getUserListOrderedDesc()) {
                userBasicResponseList.add(new UserBasicResponse(userEntity.getId(), userEntity.getName()));
            }
            UserFollowersListResponse expected = new UserFollowersListResponse(userId, userName, userBasicResponseList);


            /* Mock of seller user entity */
            UserEntity seller = UserFactory.getUserWithFollowers(userId, userName);
            Mockito.when(userRepository.getEntityById(userId))
                    .thenReturn(seller);
            /* Mock of followers user entities */
            List<UserEntity> userListUnordered = UserFactory.getUserListUnordered();
            for (UserEntity userEntity : userListUnordered) {
                Mockito.when(userRepository.getEntityById(userEntity.getId()))
                        .thenReturn(userEntity);
            }

            // Act
            UserFollowersListResponse result = userService.getFollowersUsersById(userId, order);

            // Assert
            Assertions.assertEquals(expected, result);

        }
    }

    @Nested
    @DisplayName("T-0007 - Verify that the number of followers of a given user is correct")
    class getUserFollowersCount {

        @Test
        @DisplayName("Success")
        void test1() {

            //Arrange
            int userId = 10;
            String userName = "Gloria";

            //Mock
            Mockito.when(userRepository.getEntityById(userId)).thenReturn(UserFactory.getUserWithFollowers(userId, userName));

            //Act
            UserFollowerCountResponse response = userService.getUserFollowersCount(userId);

            //Assert
            assertEquals(response.getFollowersCount(), 3);

        }
    }

}

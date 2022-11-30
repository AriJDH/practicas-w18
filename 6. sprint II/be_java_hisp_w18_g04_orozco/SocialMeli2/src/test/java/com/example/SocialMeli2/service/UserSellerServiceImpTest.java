package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.FollowerCountDTORes;
import com.example.SocialMeli2.dto.respose.FollowerListDTORes;
import com.example.SocialMeli2.dto.respose.UserDTORes;
import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;
import com.example.SocialMeli2.exception.UserNotFoundException;
import com.example.SocialMeli2.repository.IUserBuyerRepository;
import com.example.SocialMeli2.repository.IUserSellerRepository;
import com.example.SocialMeli2.util.UserSellerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserSellerServiceImpTest {
    @Mock
    IUserBuyerRepository userBuyerRepository;

    @Mock
    IUserSellerRepository userSellerRepository;

    @InjectMocks
    UserSellerServiceImp userSellerServiceImp;

    @Nested
    @DisplayName("T-0003. US-0008")
    public class Test0003 {
        @Test
        @DisplayName("Catch the exception if order is 'invalid'")
        void orderFollowersInvalidException() {
            //Arrange
            String order = "invalid";
            UserSeller seller = UserSellerFactory.getUserSeller();
            //Assert
            assertThrows(UserNotFoundException.class,
                    () -> userSellerServiceImp.getFollowers(seller.getUser_id(), order));
        }

        @Test
        @DisplayName("Verify the correct operation if order is 'name_asc'")
        void orderFollowersOrderAsc() {
            //Arrange
            String order = "name_asc";
            UserSeller seller = UserSellerFactory.getUserSeller();

            //Mock
            when(userSellerRepository.findById(1)).thenReturn(Optional.of(seller));
            FollowerListDTORes result = userSellerServiceImp.getFollowers(seller.getUser_id(), order);
            verify(userSellerRepository).findById(1);

            // Assert
            assertAll(
                    () -> assertEquals(seller.getUser_id(), result.getUser_id()),
                    () -> assertEquals(seller.getUser_name(), result.getUser_name()),
                    () -> assertEquals(seller.getFollowers(), result.getFollowers())
            );
        }

        @Test
        @DisplayName("Verify the correct operation if order is 'name_desc'")
        void orderFollowersOrderDesc() {
            String order = "name_desc";
            UserSeller seller = UserSellerFactory.getUserSeller();

            //Mock
            when(userSellerRepository.findById(1)).thenReturn(Optional.of(seller));
            FollowerListDTORes result = userSellerServiceImp.getFollowers(seller.getUser_id(), order);
            verify(userSellerRepository).findById(1);

            // Assert
            assertAll(
                    () -> assertEquals(seller.getUser_id(), result.getUser_id()),
                    () -> assertEquals(seller.getUser_name(), result.getUser_name()),
                    () -> assertEquals(seller.getFollowers(), result.getFollowers())
            );
        }
    }

    @Nested
    @DisplayName("T-0004. US-0008")
    public class Test0004 {
        @Test
        @DisplayName("Verify the correct ascendent sortering by 'name_asc' in followers")
        void ascendentSortFollowersTestOk() {
            //Arrange
            String order = "name_asc";
            Integer sellerUserId = 2;

            UserSeller userSeller = UserSellerFactory.getUserSeller2();


            List<UserDTORes> expected = new ArrayList<>();
            expected.add(new UserDTORes(1, "Josep"));
            expected.add(new UserDTORes(4, "Kevin"));
            expected.add(new UserDTORes(3, "Louis"));

            //Act
            when(userSellerRepository.findById(sellerUserId)).thenReturn(Optional.of(userSeller));
            FollowerListDTORes followerListDTORes = userSellerServiceImp.getFollowers(sellerUserId, order);
            List<UserDTORes> result = followerListDTORes.getFollowers();

            //Assert
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Verify the correct descendent sortering by 'name_desc' in followers")
        void descendentSortFollowersTestOk() {
            //Arrange
            String order = "name_desc";
            Integer sellerUserId = 2;
            UserSeller userSeller = UserSellerFactory.getUserSeller2();


            List<UserDTORes> expected = new ArrayList<>();
            expected.add(new UserDTORes(3, "Louis"));
            expected.add(new UserDTORes(4, "Kevin"));
            expected.add(new UserDTORes(1, "Josep"));

            //Act
            when(userSellerRepository.findById(sellerUserId)).thenReturn(Optional.of(userSeller));
            FollowerListDTORes followerListDTORes = userSellerServiceImp.getFollowers(sellerUserId, order);
            List<UserDTORes> result = followerListDTORes.getFollowers();

            //Assert
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("T-0007. US-0002")
    public class Test0007 {
        @Test
        @DisplayName("Verify that the number of followers of a certain user is correct.")
        void countFollowersTest() {

            UserSeller seller = UserSellerFactory.getUserSeller();

            when(userSellerRepository.findById(1)).thenReturn(Optional.of(seller));

            FollowerCountDTORes follCountDtoRes = userSellerServiceImp.followersCount(seller.getUser_id());
            assertEquals(seller.getFollowers().size(), follCountDtoRes.getFollowers_count());
        }

        @Test
        @DisplayName("Exception verify that the number of followers of a certain user is correct.")
        void countFollowersExceptionTest() {

            when(userSellerRepository.findById(15)).thenReturn(Optional.empty());
            assertThrows(UserNotFoundException.class,
                    () -> userSellerServiceImp.followersCount(15)
            );
        }
    }
}



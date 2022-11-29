package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.FollowedListDTORes;
import com.example.SocialMeli2.dto.respose.FollowerListDTORes;
import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;
import com.example.SocialMeli2.exception.UserNotFoundException;
import com.example.SocialMeli2.repository.IUserBuyerRepository;
import com.example.SocialMeli2.repository.IUserSellerRepository;
import com.example.SocialMeli2.util.UserBuyerFactory;
import com.example.SocialMeli2.util.UserSellerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    @Test
    @DisplayName("T-0003. US-0008. Catch the exception if order is 'invalid' ")
    void orderFollowersInvalidException(){
        //Arrange
       String order = "invalid";
        UserSeller seller = UserSellerFactory.getUserSeller();
        //Assert
       assertThrows(UserNotFoundException.class,
               ()-> userSellerServiceImp.getFollowers(seller.getUser_id(), order));
    }
    @Test
    @DisplayName("T-0003. US-0008. Verify the correct operation if order is 'name_asc'")
    void orderFollowersOrderAsc(){
        //Arrange
        String order = "name_asc";
        UserSeller seller = UserSellerFactory.getUserSeller();

        //Mock
        when(userSellerRepository.findById(1)).thenReturn(Optional.of(seller));
      FollowerListDTORes result = userSellerServiceImp.getFollowers(seller.getUser_id(),order);
      verify(userSellerRepository).findById(1);

      // Assert
        assertAll(
                ()-> assertEquals(seller.getUser_id(), result.getUser_id()),
                ()-> assertEquals(seller.getUser_name(), result.getUser_name()),
                ()-> assertEquals(seller.getFollowers(), result.getFollowers())
        );
    }

    @Test
    @DisplayName("T-0003. US-0008. Verify the correct operation if order is 'name_desc'")
    void orderFollowersOrderDesc(){
        String order = "name_desc";
        UserSeller seller = UserSellerFactory.getUserSeller();

        //Mock
        when(userSellerRepository.findById(1)).thenReturn(Optional.of(seller));
        FollowerListDTORes result = userSellerServiceImp.getFollowers(seller.getUser_id(),order);
        verify(userSellerRepository).findById(1);

        // Assert
        assertAll(
                ()-> assertEquals(seller.getUser_id(), result.getUser_id()),
                ()-> assertEquals(seller.getUser_name(), result.getUser_name()),
                ()-> assertEquals(seller.getFollowers(), result.getFollowers())
        );
    }
    }



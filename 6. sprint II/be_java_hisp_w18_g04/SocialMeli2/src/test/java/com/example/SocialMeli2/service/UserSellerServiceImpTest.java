package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.FollowedListDTORes;
import com.example.SocialMeli2.dto.respose.FollowerListDTORes;
import com.example.SocialMeli2.dto.respose.UserDTORes;
import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;
import com.example.SocialMeli2.exception.UserNotFoundException;
import com.example.SocialMeli2.repository.IUserBuyerRepository;
import com.example.SocialMeli2.repository.IUserSellerRepository;
import com.example.SocialMeli2.util.UserBuyerFactory;
import com.example.SocialMeli2.util.UserSellerFactory;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("T-0004. US-0008. Verify the correct ascendent sortering by 'name_asc' in followers")
    void ascendentSortFollowersTestOk(){
        //Arrange
        String order= "name_asc";
        Integer sellerUserId=2;

        List<UserBuyer> followers =new ArrayList<>();
        UserBuyer userBuyer1=new UserBuyer(); userBuyer1.setUser_id(1); userBuyer1.setUser_name("Josep");
        UserBuyer userBuyer2=new UserBuyer(); userBuyer2.setUser_id(3); userBuyer2.setUser_name("Louis");
        UserBuyer userBuyer3=new UserBuyer(); userBuyer3.setUser_id(4); userBuyer3.setUser_name("Kevin");
        followers.add(userBuyer1);
        followers.add(userBuyer2);
        followers.add(userBuyer3);
        UserSeller userSeller=new UserSeller();
        userSeller.setUser_id(2);
        userSeller.setUser_name("Ethan");
        userSeller.setFollowers(followers);
        userSeller.setPosts(new ArrayList<>());

        List<UserDTORes> expected =new ArrayList<>();
        expected.add(new UserDTORes(1,"Josep"));
        expected.add(new UserDTORes(4,"Kevin"));
        expected.add(new UserDTORes(3,"Louis"));

        //Act
        when(userSellerRepository.findById(sellerUserId)).thenReturn(Optional.of(userSeller));
        FollowerListDTORes followerListDTORes= userSellerServiceImp.getFollowers(sellerUserId,order);
        List<UserDTORes> result= followerListDTORes.getFollowers();

        //Assert
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("T-0004. US-0008. Verify the correct descendent sortering by 'name_desc' in followers")
    void descendentSortFollowersTestOk(){
        //Arrange
        String order= "name_desc";
        Integer sellerUserId=2;

        List<UserBuyer> followers =new ArrayList<>();
        UserBuyer userBuyer1=new UserBuyer(); userBuyer1.setUser_id(1); userBuyer1.setUser_name("Josep");
        UserBuyer userBuyer2=new UserBuyer(); userBuyer2.setUser_id(3); userBuyer2.setUser_name("Louis");
        UserBuyer userBuyer3=new UserBuyer(); userBuyer3.setUser_id(4); userBuyer3.setUser_name("Kevin");
        followers.add(userBuyer1);
        followers.add(userBuyer2);
        followers.add(userBuyer3);
        UserSeller userSeller=new UserSeller();
        userSeller.setUser_id(2);
        userSeller.setUser_name("Ethan");
        userSeller.setFollowers(followers);
        userSeller.setPosts(new ArrayList<>());

        List<UserDTORes> expected =new ArrayList<>();
        expected.add(new UserDTORes(3,"Louis"));
        expected.add(new UserDTORes(4,"Kevin"));
        expected.add(new UserDTORes(1,"Josep"));

        //Act
        when(userSellerRepository.findById(sellerUserId)).thenReturn(Optional.of(userSeller));
        FollowerListDTORes followerListDTORes= userSellerServiceImp.getFollowers(sellerUserId,order);
        List<UserDTORes> result= followerListDTORes.getFollowers();

        //Assert
        assertEquals(expected,result);
    }

}



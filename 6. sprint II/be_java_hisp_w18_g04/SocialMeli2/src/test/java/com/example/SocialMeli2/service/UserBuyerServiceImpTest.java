package com.example.SocialMeli2.service;

import com.example.SocialMeli2.dto.respose.FollowDTORes;

import com.example.SocialMeli2.entity.UserBuyer;
import com.example.SocialMeli2.entity.UserSeller;
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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserBuyerServiceImpTest {
    @Mock
    IUserBuyerRepository userBuyerRepository;

    @Mock
    IUserSellerRepository userSellerRepository;

    @InjectMocks
    UserBuyerServiceImp userBuyerServiceImp;

    @Test
    @DisplayName("T-0001. US-0001. The user to follow exists")
    void userToFollowExistsOK() {
        //GIVEN
        Integer userId = 3;
        Integer userToFollow = 3;

        //WHEN
        when(userSellerRepository.findAll()).thenReturn(UserSellerFactory.getUserSellerList());
        when(userBuyerRepository.findAll()).thenReturn(UserBuyerFactory.getUserBuyerList());
        when(userBuyerRepository.findById(userId)).thenReturn(UserBuyerFactory.getUserBuyer());
        when(userSellerRepository.findById(userToFollow)).thenReturn(UserSellerFactory.getUserSeller());

        UserSellerFactory.getUserSeller().getFollowers().add(UserBuyerFactory.getUserBuyer());
        UserBuyerFactory.getUserBuyer().getFollowed().add(UserSellerFactory.getUserSeller());

        FollowDTORes followDTORes = userBuyerServiceImp.follow(userId,userToFollow);
        String userName = followDTORes.getUserNameFollowed();

        //THEN
        assertEquals("Kyle",userName);

    }
}
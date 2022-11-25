package com.example.SocialMeli2.repository;

import com.example.SocialMeli2.entity.UserBuyer;

import java.util.List;

public interface IUserBuyerRepository {
    UserBuyer findById(Integer id);

    List<UserBuyer> findAll();

}

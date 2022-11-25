package com.example.SocialMeli2.repository;

import com.example.SocialMeli2.entity.UserSeller;

import java.util.List;

public interface IUserSellerRepository {
    UserSeller findById(Integer id);

    List<UserSeller> findAll();
}

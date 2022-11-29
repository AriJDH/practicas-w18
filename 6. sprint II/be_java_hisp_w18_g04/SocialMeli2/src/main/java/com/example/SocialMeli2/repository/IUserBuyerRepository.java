package com.example.SocialMeli2.repository;

import com.example.SocialMeli2.entity.UserBuyer;

import java.util.List;
import java.util.Optional;

public interface IUserBuyerRepository {
    Optional<UserBuyer> findById(Integer id);

    List<UserBuyer> findAll();

}

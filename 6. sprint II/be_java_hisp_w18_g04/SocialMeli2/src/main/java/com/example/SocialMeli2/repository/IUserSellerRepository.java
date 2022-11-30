package com.example.SocialMeli2.repository;

import com.example.SocialMeli2.entity.UserSeller;

import java.util.List;
import java.util.Optional;

public interface IUserSellerRepository {
    Optional<UserSeller> findById(Integer id);

    List<UserSeller> findAll();
}

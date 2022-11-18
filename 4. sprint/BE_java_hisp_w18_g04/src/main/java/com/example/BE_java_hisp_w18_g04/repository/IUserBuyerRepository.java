package com.example.BE_java_hisp_w18_g04.repository;

import com.example.BE_java_hisp_w18_g04.entity.UserBuyer;

import java.util.List;

public interface IUserBuyerRepository{
    UserBuyer findById(Integer id);

    List<UserBuyer> findAll();

}

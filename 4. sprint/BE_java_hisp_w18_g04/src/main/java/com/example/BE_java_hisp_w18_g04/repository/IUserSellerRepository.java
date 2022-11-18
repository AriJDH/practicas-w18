package com.example.BE_java_hisp_w18_g04.repository;

import com.example.BE_java_hisp_w18_g04.entity.UserSeller;

import java.util.List;

public interface IUserSellerRepository{
    UserSeller findById(Integer id);
    List<UserSeller> findAll();
}

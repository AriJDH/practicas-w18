package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;

import com.socialmedia.be_java_hisp_w18_g08.entity.User;

import java.util.Optional;

public interface IUserRepository {
    Seller findUserListBySeller(Integer id);

    User getUserByID(Integer userId);
}

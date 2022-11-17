package com.socialmedia.be_java_hisp_w18_g08.repository;

import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;

import com.socialmedia.be_java_hisp_w18_g08.entity.User;

import java.util.List;

public interface IUserRepository {
    Seller findSellerById(Integer id);

    List<String> follow (Integer userId, Integer userIdToFollow);
    User getUserByID(Integer userId);

    String unFollow(Integer userId,Integer userIdToUnfollow);
}

package com.socialmeli.be_java_hisp_w18g05.service;

import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersListDTOResponse;

import java.util.List;

public interface IService {

    SellerFollowersListDTOResponse getFollowers(Integer seller_id);

    void follow(Integer userId, Integer userIdToFollow);
    void unfollow(Integer userId, Integer userIdToUnfollow);

    //SellerFollowersCountDTOResponse followersCount(Integer user_id);
}

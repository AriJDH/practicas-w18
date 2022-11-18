package com.socialmeli.be_java_hisp_w18g05.service;

import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPromoPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;

import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;


import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;

import java.util.List;

public interface IService {

    SellerFollowersListDTOResponse followersFilter(Integer seller_id, String order);
    SellerFollowersListDTOResponse getFollowers(Integer seller_id);

    SellerFollowersListDTOResponse getFollowersAZ(Integer seller_id);
    SellerFollowersListDTOResponse getFollowersZA(Integer seller_id);

    BuyerFollowedListDTOResponse followedsFilter(Integer seller_id, String order);
    BuyerFollowedListDTOResponse getFolloweds(Integer buyer_id);
    BuyerFollowedListDTOResponse getFollowedsAZ(Integer buyer_id);
    BuyerFollowedListDTOResponse getFollowedsZA(Integer buyer_id);
    void follow(Integer userId, Integer userIdToFollow);
    void unfollow(Integer userId, Integer userIdToUnfollow);
    void newPost(NewPostDTORequest post);
    void newPromoPost(NewPromoPostDTORequest post);
    SellerFollowersCountDTOResponse followersCount(Integer user_id);

    SellerPostListDTOResponse followedPostList(Integer user_id, String order);

    PromoPostCountDTOResponse promoPostCount(Integer user_id);

    InfoSellerDTOResponse infoSeller(Integer user_id);


}

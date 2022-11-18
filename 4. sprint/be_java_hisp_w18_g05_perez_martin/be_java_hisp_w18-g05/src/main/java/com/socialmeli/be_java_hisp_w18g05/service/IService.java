package com.socialmeli.be_java_hisp_w18g05.service;

import com.socialmeli.be_java_hisp_w18g05.dto.request.PostPromoDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.response.*;
import com.socialmeli.be_java_hisp_w18g05.dto.request.NewPostDTORequest;
import com.socialmeli.be_java_hisp_w18g05.dto.response.SellerFollowersCountDTOResponse;

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

    // Individual US0010
    void postPromo(PostPromoDTORequest post);

    // Individual US0011
    PostPromoCountDTOResponse postPromoCount(Integer user_id);


    SellerFollowersCountDTOResponse followersCount(Integer user_id);

    SellerPostListDTOResponse followedPostList(Integer user_id, String order);

    //SellerPostListDTOResponse order(Integer userId, String order);






    //SellerFollowersCountDTOResponse followersCount(Integer user_id);
}

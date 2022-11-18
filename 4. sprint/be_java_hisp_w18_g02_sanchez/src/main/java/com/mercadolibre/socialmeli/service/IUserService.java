package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;

import java.util.List;

public interface IUserService {
    String follow(Integer userId, Integer userIdToFollow);
    String unfollow(Integer userId, Integer userIdToFollow);
    SellerFollowerCountDtoRes getCount(Integer id);
    SellerFollowerListDtoRes getFollowers(Integer id, String order);
    UserFollowedListDtoRes getFollowed(Integer id, String order);
    void addPost(PostDtoReq postReq);
    PostsGroupedByUserDtoRes getRecentPosts(Integer userId, String order);
    SellerPromoCountDtoRes getSellerPromoCount(Integer userId);
    PostsGroupedByUserDtoRes getSellerPromoList(Integer userId, String order);
    List<PostDtoRes> getAllPromos(String order);

}

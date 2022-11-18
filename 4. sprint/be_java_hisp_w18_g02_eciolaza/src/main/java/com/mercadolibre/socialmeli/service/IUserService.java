package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.request.PromoDtoReq;
import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;

public interface IUserService {
    String follow(Integer userId, Integer userIdToFollow);
    String unfollow(Integer userId, Integer userIdToFollow);
    SellerFollowerCountDtoRes getCount(Integer id);
    SellerFollowerListDtoRes getFollowers(Integer id, String order);
    UserFollowedListDtoRes getFollowed(Integer id, String order);
    void addPost(PostDtoReq postReq);
    void addPromo(PromoDtoReq promoReq);
    RecentPostsDtoRes getRecentPosts(Integer userId, String order);
    PromoCountDtoRes promoCount(Integer userId);

}

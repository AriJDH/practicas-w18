package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.request.PromoPostDtoReq;
import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.entity.Post;

import java.util.List;

public interface IUserService {
    String follow(Integer userId, Integer userIdToFollow);
    String unfollow(Integer userId, Integer userIdToFollow);
    SellerFollowerCountDtoRes getCount(Integer id);
    SellerFollowerListDtoRes getFollowers(Integer id, String order);
    UserFollowedListDtoRes getFollowed(Integer id, String order);
    void addPost(PostDtoReq postReq);
    void addPromoPost(PromoPostDtoReq promoPostReq);
    SellerPromoPostsDtoRes getPromoPostsFromSeller(Integer id);
    RecentPostsDtoRes getRecentPosts(Integer userId, String order);

}

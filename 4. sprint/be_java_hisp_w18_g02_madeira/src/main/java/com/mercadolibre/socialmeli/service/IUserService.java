package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.PromoPostDto;
import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;

public interface IUserService {
    String follow(Integer userId, Integer userIdToFollow);
    String unfollow(Integer userId, Integer userIdToFollow);
    SellerFollowerCountDtoRes getCount(Integer id);
    SellerFollowerListDtoRes getFollowers(Integer id, String order);
    UserFollowedListDtoRes getFollowed(Integer id, String order);
    String addPost(PostDtoReq postReq);
    RecentPostsDtoRes getRecentPosts(Integer userId, String order);

    // INDIVIDUAL
    String addPromoPost(PromoPostDto promoPostDto);
    PromoPostCountDtoRes countPromoProducts(Integer userId);
    // BONUS
    PromoPostsDtoRes getPromoProducts(Integer userId, String order);
    PromoPostsDtoRes getPromoRecommendation(Integer userId, String order);
}

package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.request.PostDiscountDtoReq;
import com.mercadolibre.socialmeli.dto.response.*;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;

public interface IUserService {
    String follow(Integer userId, Integer userIdToFollow);
    String unfollow(Integer userId, Integer userIdToFollow);
    SellerFollowerCountDtoRes getCount(Integer id);
    SellerFollowerListDtoRes getFollowers(Integer id, String order);
    UserFollowedListDtoRes getFollowed(Integer id, String order);
    void addPost(PostDtoReq postReq);
    RecentPostsDtoRes getRecentPosts(Integer userId, String order);
    void addPostWithPromo(PostDiscountDtoReq postDiscountDtoReq);

    CountPromoDtoRes getCountPromo(Integer userId);

    PromoPostsDtoRes getPromoPost(Integer userId, String order);

    CountProductsDtoRes getCountProducts(Integer userId);

    PostsDtoRes getAllPost(Integer userId, String order);
}

package com.mercadolibre.socialmeli2.service;

import com.mercadolibre.socialmeli2.dto.response.RecentPostsDtoRes;
import com.mercadolibre.socialmeli2.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli2.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli2.dto.response.UserFollowedListDtoRes;

public interface IUserService {
    String follow(Integer userId, Integer userIdToFollow);
    String unfollow(Integer userId, Integer userIdToFollow);
    SellerFollowerCountDtoRes getCount(Integer id);
    SellerFollowerListDtoRes getFollowers(Integer id, String order);
    UserFollowedListDtoRes getFollowed(Integer id, String order);
    String addPost(PostDtoReq postReq);
    RecentPostsDtoRes getRecentPosts(Integer userId, String order);

}

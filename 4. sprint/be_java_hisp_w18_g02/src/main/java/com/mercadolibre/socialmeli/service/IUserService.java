package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli.dto.response.UserFollowedListDtoRes;
import com.mercadolibre.socialmeli.dto.request.PostDtoReq;
import org.springframework.stereotype.Service;


public interface IUserService {
    public String follow(Integer userId, Integer userIdToFollow);
    public String unfollow(Integer userId, Integer userIdToFollow);

    SellerFollowerCountDtoRes getCount(Integer id);
    SellerFollowerListDtoRes getFollowers(Integer id, String order);
    UserFollowedListDtoRes getFollowed(Integer id, String order);
    void addPost(PostDtoReq postReq);
}

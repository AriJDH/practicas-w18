package com.mercadolibre.socialmeli.service;

import com.mercadolibre.socialmeli.dto.response.SellerFollowerCountDtoRes;
import com.mercadolibre.socialmeli.dto.response.SellerFollowerListDtoRes;
import com.mercadolibre.socialmeli.dto.response.UserFollowedListDtoRes;
import org.springframework.stereotype.Service;


public interface IUserService {
    SellerFollowerCountDtoRes getCount(Integer id);
    SellerFollowerListDtoRes getFollowers(Integer id);
    UserFollowedListDtoRes getFollowed(Integer id);
}

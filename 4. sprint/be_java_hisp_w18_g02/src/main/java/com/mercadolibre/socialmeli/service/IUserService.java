package com.mercadolibre.socialmeli.service;

import org.springframework.stereotype.Service;


public interface IUserService {
    public String follow(Integer userId, Integer userIdToFollow);
    public String unfollow(Integer userId, Integer userIdToFollow);

}

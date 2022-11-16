package com.sprint1.be_java_hisp_w18_g03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprint1.be_java_hisp_w18_g03.repository.IUserRepository;

@Service
public class UserServiceImp implements IUserService{

    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public ResponseDTO follow(Integer userId, Integer followId) {
        return null;
    }

    @Override
    public FollowerCountDTO followerCount(Integer userId) {
        return null;
    }

    @Override
    public FollowersDTO getFollowersList(Integer userId) {
        return null;
    }

    @Override
    public FollowedDTO getFollowedList(Integer userId) {
        return null;
    }

    @Override
    public ResponseDTO unfollow(Integer userId, Integer followId) {
        return null;
    }
}

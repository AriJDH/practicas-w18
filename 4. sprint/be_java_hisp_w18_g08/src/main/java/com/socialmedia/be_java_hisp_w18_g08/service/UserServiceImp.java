package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements IUserService{

    IUserRepository userRepository;

    public UserServiceImp(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public FollowDtoRes follow(FollowDtoReq followDtoReq) {
        List<String> res = new ArrayList<>();
        FollowDtoRes followDtoRes = new FollowDtoRes();
        res = userRepository.follow(followDtoReq.getUserId(), followDtoReq.getUserIdToFollow());
        followDtoRes.setStatusCode(200);
        followDtoRes.setMessage(res.get(0) + " is following " + res.get(1));
        return followDtoRes;

    }
}

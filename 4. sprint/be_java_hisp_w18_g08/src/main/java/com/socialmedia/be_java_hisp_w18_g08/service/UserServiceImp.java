package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.repository.IUserRepository;
import com.socialmedia.be_java_hisp_w18_g08.repository.UserRepositoryImp;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements IUserService{

    private IUserRepository userRepository;

    public UserServiceImp(UserRepositoryImp repo){
        this.userRepository = repo;
    }

    @Override
    public FollowedDTO getFollowed(Integer userId) {
        return null;
    }
}

package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;
import com.dh.be_java_hisp_w18_g10.entity.User;
import com.dh.be_java_hisp_w18_g10.util.DTOMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    public void test(User user){
        UserPostsDTOres userPosts = DTOMapper.mapTo(user);

    }
}

package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;

public interface IUserService {
    FollowedDTO getFollowed(Integer userId);
}

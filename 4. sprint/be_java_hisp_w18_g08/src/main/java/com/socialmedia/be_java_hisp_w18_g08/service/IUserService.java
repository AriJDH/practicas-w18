package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;

import java.util.List;

public interface IUserService {
    FollowedDTO getFollowed(Integer userId);
    public List<Seller> getFollowedByUserId(Integer userId);
}

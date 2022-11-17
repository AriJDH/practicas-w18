package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;

import java.util.List;

public interface IUserService {

    FollowDtoRes follow (FollowDtoReq followDtoReq);
    FollowedDTO getFollowed(Integer userId);
    public List<Seller> getFollowedByUserId(Integer userId);
}

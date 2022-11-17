package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.SellerDTO;
import com.socialmedia.be_java_hisp_w18_g08.dto.SellerFollowersCountDTO;

public interface IUserService {
    FollowedDTO getFollowed(Integer userId);

    SellerFollowersCountDTO findAllFollowersQuantity(long id);
}

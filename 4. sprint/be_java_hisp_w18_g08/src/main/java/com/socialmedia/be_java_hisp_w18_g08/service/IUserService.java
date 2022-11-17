package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.UserListDTO;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;

import com.socialmedia.be_java_hisp_w18_g08.dto.request.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowDtoRes;
import com.socialmedia.be_java_hisp_w18_g08.dto.FollowedDTO;
import org.springframework.web.bind.annotation.PathVariable;
import com.socialmedia.be_java_hisp_w18_g08.dto.SellerFollowersCountDTO;


import java.util.List;

public interface IUserService {

    FollowDtoRes follow (FollowDtoReq followDtoReq);

    FollowedDTO getFollowed(Integer userId, String order);

    UserListDTO findUserListBySeller(Integer id, String order);

    SellerFollowersCountDTO findAllFollowersQuantity(Integer id);

    List<Seller> getFollowedByUserId(Integer userId);
    String unFollow(Integer userId,Integer userIdToUnfollow);
}

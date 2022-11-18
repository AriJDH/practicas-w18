package com.socialmedia.be_java_hisp_w18_Otero.service;

import com.socialmedia.be_java_hisp_w18_Otero.dto.response.UserListDto;
import com.socialmedia.be_java_hisp_w18_Otero.entity.Seller;
import com.socialmedia.be_java_hisp_w18_Otero.dto.request.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.FollowDtoRes;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.FollowedDto;
import com.socialmedia.be_java_hisp_w18_Otero.dto.response.SellerFollowersCountDto;

import java.util.List;

public interface IUserService {

    FollowDtoRes follow (FollowDtoReq followDtoReq);

    FollowedDto getFollowed(Integer userId, String order);

    UserListDto findUserListBySeller(Integer id, String order);

    SellerFollowersCountDto findAllFollowersQuantity(Integer id);

    List<Seller> getFollowedByUserId(Integer userId);

    String unFollow(Integer userId,Integer userIdToUnfollow);
}

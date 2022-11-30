package com.socialmedia2.be_java_hisp_w18_g08.service;

import com.socialmedia2.be_java_hisp_w18_g08.dto.response.*;
import com.socialmedia2.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia2.be_java_hisp_w18_g08.dto.request.FollowDtoReq;

import java.util.List;

public interface IUserService {

    FollowDtoRes follow (FollowDtoReq followDtoReq);


    void changeOrder(List<UserDto> list, String order);
    FollowedDto getFollowed(Integer userId, String order);

    UserListDto findUserListBySeller(Integer id, String order);

    SellerFollowersCountDto findAllFollowersQuantity(Integer id);

    List<Seller> getFollowedByUserId(Integer userId);

    String unFollow(Integer userId,Integer userIdToUnfollow);
}

package com.socialmedia.be_java_hisp_w18_g08.service;

import com.socialmedia.be_java_hisp_w18_g08.dto.response.*;
import com.socialmedia.be_java_hisp_w18_g08.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08.dto.request.FollowDtoReq;

import java.util.List;

public interface IUserService {

    FollowDtoRes follow (FollowDtoReq followDtoReq);

    FollowedDto getFollowed(Integer userId, String order);

    UserListDto findUserListBySeller(Integer id, String order);

    SellerFollowersCountDto findAllFollowersQuantity(Integer id);

    List<Seller> getFollowedByUserId(Integer userId);

    String unFollow(Integer userId,Integer userIdToUnfollow);

    ListPostSellerDtoRes getListPostsBySeller(Integer UserId);
}

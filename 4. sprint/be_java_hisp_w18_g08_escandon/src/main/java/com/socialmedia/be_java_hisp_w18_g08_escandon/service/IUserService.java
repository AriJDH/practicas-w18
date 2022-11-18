package com.socialmedia.be_java_hisp_w18_g08_escandon.service;

import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.UserListDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.entity.Seller;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.request.FollowDtoReq;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.FollowDtoRes;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.FollowedDto;
import com.socialmedia.be_java_hisp_w18_g08_escandon.dto.response.SellerFollowersCountDto;

import java.util.List;

public interface IUserService {

    FollowDtoRes follow (FollowDtoReq followDtoReq);

    FollowedDto getFollowed(Integer userId, String order);

    UserListDto findUserListBySeller(Integer id, String order);

    SellerFollowersCountDto findAllFollowersQuantity(Integer id);

    List<Seller> getFollowedByUserId(Integer userId);

    String unFollow(Integer userId,Integer userIdToUnfollow);
}

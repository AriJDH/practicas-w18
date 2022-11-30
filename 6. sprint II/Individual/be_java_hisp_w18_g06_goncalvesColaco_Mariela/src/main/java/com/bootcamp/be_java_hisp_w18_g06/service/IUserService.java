package com.bootcamp.be_java_hisp_w18_g06.service;

import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowedListDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersCountDTO;
import com.bootcamp.be_java_hisp_w18_g06.dto.response.UserFollowersListDTO;

public interface IUserService {
	void followUser(Integer userId, Integer userIdToFollow);
	
	void unfollowUser(Integer userId, Integer userIdToUnfollow);
	
	UserFollowersCountDTO getFollowersCount(int userId);
	
	UserFollowedListDTO getFollowedList(int userId, String order);
	
	UserFollowersListDTO getFollowersList(int userId, String order);
	
}

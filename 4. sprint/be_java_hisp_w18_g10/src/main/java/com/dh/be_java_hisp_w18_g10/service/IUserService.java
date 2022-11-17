package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowedListDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersCountDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserFollowersListDTOres;
import com.dh.be_java_hisp_w18_g10.dto.response.UserPostsDTOres;

public interface IUserService {
    void followUser(int userId, int userIdToFollow);
    UserFollowersCountDTOres getUserFollowersCount(int userId);
    UserFollowersListDTOres getUserFollowerList(int userId);
    UserFollowedListDTOres getUserFollowed(int userId);
    void createPost(PostDTOreq postDTO);
    UserPostsDTOres getUserPosts(int userId);
    void unfollowUser(int userId, int userIdToUnfollow);

}

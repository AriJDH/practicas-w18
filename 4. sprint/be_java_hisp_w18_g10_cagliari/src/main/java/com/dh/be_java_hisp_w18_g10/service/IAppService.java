package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;

public interface IAppService {
    void followUser(int userId, int userIdToFollow);
    void unfollowUser(int userId, int userIdToUnfollow);
    void createPost(PostDTOreq postDTO);
    UserFollowersCountDTOres getUserFollowersCount(int userId);
    UserFollowersDTOres getUserFollowers(int userId);
    UserFollowersDTOres getUserFollowers(int userId, String order);
    UserFollowedDTOres getUserFollowed(int userId);
    UserFollowedDTOres getUserFollowed(int userId, String order);
    UserPostsDTOres getUserPosts(int userId);
    UserPostsDTOres getUserPosts(int userId, String order);
    UserPromoPostCountDTOres getUserPromoPostCount(int userId);
    UserPromoPostsDTOres getUserPromoPosts(int userId);

}

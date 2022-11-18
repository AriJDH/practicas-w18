package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;

public interface IAppService {
    void followUser(int userId, int userIdToFollow);
    UserFollowersCountDTOres getUserFollowersCount(int userId);
    UserFollowersDTOres getUserFollowerList(int userId);
    UserFollowersDTOres getUserFollowerList(int userId, String order);
    UserFollowedDTOres getUserFollowed(int userId);
    UserFollowedDTOres getUserFollowed(int userId, String order);
    void createPost(PostDTOreq postDTO);
    UserPostsDTOres getUserPosts(int userId, String order);
    void unfollowUser(int userId, int userIdToUnfollow);
    UserPromoPostCountDTOres getUserPromoPostCount(int userId);
    UserPromoPostsDTOres getUserPromoPosts(int userId);

}

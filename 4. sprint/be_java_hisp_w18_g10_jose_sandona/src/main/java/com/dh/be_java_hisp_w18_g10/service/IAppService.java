package com.dh.be_java_hisp_w18_g10.service;

import com.dh.be_java_hisp_w18_g10.dto.require.PostDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.require.PostPromotionDTOreq;
import com.dh.be_java_hisp_w18_g10.dto.response.*;

public interface IAppService {
    void followUser(int userId, int userIdToFollow);
    UserFollowersCountDTOres getUserFollowersCount(int userId);
    UserFollowersListDTOres getUserFollowerList(int userId);
    UserFollowersListDTOres getUserFollowerList(int userId, String order);
    UserFollowedListDTOres getUserFollowed(int userId);
    UserFollowedListDTOres getUserFollowed(int userId, String order);
    void createPost(PostDTOreq postDTO);
    UserPostsDTOres getUserPosts(int userId, String order);
    void unfollowUser(int userId, int userIdToUnfollow);
    void createPostPromotion(PostPromotionDTOreq postPromotionDTOreq);
    PostProductsPromotionDTOres getProductsPromotionCount(int id);
    MessageDTO deactivatePromotion(int userId, int postPromotionId);

}

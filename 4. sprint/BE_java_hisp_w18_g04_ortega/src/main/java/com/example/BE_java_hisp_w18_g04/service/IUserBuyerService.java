package com.example.BE_java_hisp_w18_g04.service;

import com.example.BE_java_hisp_w18_g04.dto.respose.FollowedListDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PostDTORes;
import com.example.BE_java_hisp_w18_g04.dto.respose.PostFollowedByDateDTORes;
import com.example.BE_java_hisp_w18_g04.entity.UserSeller;

import java.util.List;

public interface IUserBuyerService {
    void follow(Integer userId, Integer userIdToFollow);
    FollowedListDTORes getFollowed(Integer userId, String order);

    PostFollowedByDateDTORes getLastPosts(Integer userId, String order);

    List<PostDTORes> filterPostByDate(List<PostDTORes> postDTOResList);

    void getPostListSeller(List<UserSeller> followed, List<PostDTORes> postsFollowed);

    void unfollow(Integer userId, Integer userIdToUnfollow);

}
